@file:Suppress("DEPRECATION")

package id.bangkit2021.capstoneproject.ui.detection

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import id.bangkit2021.capstoneproject.databinding.FragmentDetectionBinding
import id.bangkit2021.capstoneproject.tflite.Classifier
import id.bangkit2021.capstoneproject.utils.Constant
import java.io.ByteArrayOutputStream


class DetectionFragment : Fragment() {
    private var _binding: FragmentDetectionBinding? = null

    private val binding get() = _binding!!
    private lateinit var bitmap: Bitmap
    private val mInputSize = Constant.TFLITE_INPUT_SIZE
    private val mModelPath = Constant.TFLITE_FILE
    private val mLabelPath = Constant.TFLITE_LABEL
    private lateinit var classifier: Classifier


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
           Toast.makeText(requireContext(), "Fitur Sedang di kembangkan", Toast.LENGTH_SHORT).show()
        }

        binding.btnFile.setOnClickListener {
            val intent = Intent(Intent.ACTION_GET_CONTENT)
            intent.type = "image/*"
            startActivityForResult(intent, Constant.GET_IMAGE_FILE)
        }

        binding.btnUpload.setOnClickListener {
            //Insert Classification
            classifier = Classifier(requireContext().assets, mModelPath, mLabelPath, mInputSize)
            val result = classifier.recognizeImage(bitmap)

            //Convert Bitmap to Bytearray
            bitmap = (binding.imageView.drawable as BitmapDrawable).bitmap
            val stream = ByteArrayOutputStream()
            bitmap.compress(Bitmap.CompressFormat.PNG, 90, stream)
            val image = stream.toByteArray()

            //Create Intent to Detail Detection Activity
            val intentUpload = Intent(context, DetailDetectionActivity::class.java)
            //put data convert bitmap
            intentUpload.putExtra(DetailDetectionActivity.RESULT_IMAGE, image)
            //put extra Type tumor
            intentUpload.putExtra(DetailDetectionActivity.RESULT_TEXT, result[0].typeTumor)
            //send put extra to DetailDetectionActivity
            startActivity(intentUpload)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (data != null) {
            if (requestCode == Constant.GET_IMAGE_FROM_CAMERA) {
                val bmp = data.extras?.get("data") as Bitmap
                binding.imageView.setImageBitmap(bmp)
            } else if (requestCode == Constant.GET_IMAGE_FILE) {
                binding.imageView.setImageURI(data.data)
                val uri: Uri? = data.data
                bitmap = MediaStore.Images.Media.getBitmap(context?.contentResolver, uri)
            }
        }
    }
}