package id.bangkit2021.capstoneproject.tflite

import android.content.res.AssetManager
import android.graphics.Bitmap
import android.util.Log
import id.bangkit2021.capstoneproject.data.Recognition
import org.tensorflow.lite.Interpreter
import java.io.FileInputStream
import java.nio.ByteBuffer
import java.nio.ByteOrder
import java.nio.MappedByteBuffer
import java.nio.channels.FileChannel
import java.util.*
import kotlin.Comparator
import kotlin.math.min

class Classifier(assetManager: AssetManager, modelPath: String, labelPath: String,
                 private val inputSize: Int
) {
    //Variables
    private var interpreter: Interpreter
    private var labelList: List<String>
    private val pixelSize: Int = 3
    private val imageMean = 0
    private val imageStd = 255.0f
    private val maxResults = 3
    private val threshold = 0.4f

    //Initialization the Function
    init {
        val options = Interpreter.Options()
        options.setNumThreads(5)
        options.setUseNNAPI(true)
        interpreter = Interpreter(loadModelFile(assetManager, modelPath), options)
        labelList = loadLabelList(assetManager, labelPath)
    }

    //this Function is for Load the Tensorflow Lite Model
    private fun loadModelFile(assetManager: AssetManager, modelPath: String): MappedByteBuffer {
        val fileDescriptor = assetManager.openFd(modelPath)
        val inputStream = FileInputStream(fileDescriptor.fileDescriptor)
        val fileChannel = inputStream.channel
        val startOffset = fileDescriptor.startOffset
        val declaredLength = fileDescriptor.declaredLength
        return fileChannel.map(FileChannel.MapMode.READ_ONLY, startOffset, declaredLength)
    }

    //this function is for load the Labels
    private fun loadLabelList(assetManager: AssetManager, labelPath: String): List<String> {
        return assetManager.open(labelPath).bufferedReader().useLines { it.toList() }

    }

    //this function is Recognition the Image
    fun recognizeImage(bitmap: Bitmap): List<Recognition> {
        val scaledBitmap = Bitmap.createScaledBitmap(bitmap, inputSize, inputSize, false)
        val byteBuffer = convertBitmapToByteBuffer(scaledBitmap)
        val result = Array(1) { FloatArray(labelList.size) }
        interpreter.run(byteBuffer, result)
        return getSortedResult(result)
    }

    //this function is convert result bitmap to bytebuffer
    private fun convertBitmapToByteBuffer(bitmap: Bitmap): ByteBuffer {
        val byteBuffer = ByteBuffer.allocateDirect(4 * inputSize * inputSize * pixelSize)
        byteBuffer.order(ByteOrder.nativeOrder())
        val intValues = IntArray(inputSize * inputSize)

        bitmap.getPixels(intValues, 0, bitmap.width, 0, 0, bitmap.width, bitmap.height)
        var pixel = 0
        for (i in 0 until inputSize) {
            for (j in 0 until inputSize) {
                val input = intValues[pixel++]

                byteBuffer.putFloat((((input.shr(16) and 0xFF) - imageMean) / imageStd))
                byteBuffer.putFloat((((input.shr(8) and 0xFF) - imageMean) / imageStd))
                byteBuffer.putFloat((((input and 0xFF) - imageMean) / imageStd))
            }
        }
        return byteBuffer
    }

    //this function is used for gethighest Probality
    private fun getSortedResult(labelProbArray: Array<FloatArray>): List<Recognition> {
        Log.d(
            "Classifier",
            "List Size:(%d, %d, %d)".format(
                labelProbArray.size,
                labelProbArray[0].size,
                labelList.size
            )
        )

        val pq = PriorityQueue(
            maxResults,
            Comparator<Recognition> { (_, _, confidence1), (_, _, confidence2)
                ->
                confidence1.compareTo(confidence2) * -1
            })

        for (i in labelList.indices) {
            val confidence = labelProbArray[0][i]
            if (confidence >= threshold) {
                pq.add(
                    Recognition(
                        "" + i,
                        if (labelList.size > i) labelList[i] else "Unknown", confidence
                    )
                )
            }
        }
        Log.d("Classifier", "pqsize:(%d)".format(pq.size))

        val recognitions = ArrayList<Recognition>()
        val recognitionsSize = min(pq.size, maxResults)
        for (i in 0 until recognitionsSize) {
            recognitions.add(pq.poll())
        }
        return recognitions
    }


}