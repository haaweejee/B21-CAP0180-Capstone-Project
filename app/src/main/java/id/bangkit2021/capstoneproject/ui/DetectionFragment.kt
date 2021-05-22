@file:Suppress("DEPRECATION")

package id.bangkit2021.capstoneproject.ui

import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import id.bangkit2021.capstoneproject.databinding.FragmentDetectionBinding
import id.bangkit2021.capstoneproject.ml.ConvertedModel
import org.tensorflow.lite.DataType
import org.tensorflow.lite.support.image.TensorImage
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer


class DetectionFragment : Fragment() {
    private var _binding: FragmentDetectionBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private lateinit var bitmap: Bitmap

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetectionBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnPhoto.setOnClickListener {
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(intent, 123)
        }

        binding.btnFile.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK)
            intent.type = "image/*"
            startActivityForResult(intent, 456)
        }

        binding.btnUpload.setOnClickListener {
            val resized = Bitmap.createScaledBitmap(bitmap, 224,224, true)

            val model = ConvertedModel.newInstance(requireContext())

            // Creates inputs for reference.
            val inputFeature0 = TensorBuffer.createFixedSize(intArrayOf(1, 224, 224, 3), DataType.FLOAT32)

            val tBuffer = TensorImage.fromBitmap(resized)
            val byteBuffer = tBuffer.buffer
            inputFeature0.loadBuffer(byteBuffer)

            // Runs model inference and gets result.
            val outputs = model.process(inputFeature0)
            val outputFeature0 = outputs.outputFeature0AsTensorBuffer

            //For Predict Probality
            val max = getMax(outputFeature0.floatArray)

            //For Classification What it is
            val filename = "labels.txt"
            val inputString= context?.assets?.open(filename)?.bufferedReader().use { it?.readText() }
            val townList = inputString?.split("\n")

            binding.tvResult.text = townList!![max]

            // Releases model resources if no longer used.
            model.close()

        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 123){
            val bmp = data?.extras?.get("data") as Bitmap
            binding.imageView.setImageBitmap(bmp)
        }else if(requestCode == 456){
            binding.imageView.setImageURI(data?.data)
            val uri : Uri? = data?.data
            bitmap = MediaStore.Images.Media.getBitmap(context?.contentResolver, uri)
        }
    }

    private fun getMax(arr: FloatArray) : Int{
        var index = 0
        var min = 0.0f

        for (i in 0..4){
            if (arr[i]>min){
                index = i
                min = arr[i]
            }
        }

        return index
    }
}