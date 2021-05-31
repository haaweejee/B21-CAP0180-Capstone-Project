@file:Suppress("DEPRECATION")

package id.bangkit2021.capstoneproject.ui.preference

import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import id.bangkit2021.capstoneproject.PleaseWaitActivity
import id.bangkit2021.capstoneproject.R
import id.bangkit2021.capstoneproject.databinding.ActivityPreferenceBinding
import id.bangkit2021.capstoneproject.utils.Constant

class PreferenceActivity : AppCompatActivity() {

    companion object{
        const val RESULT_IMAGE = "bitmapImage"
    }

    private lateinit var binding : ActivityPreferenceBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPreferenceBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val hospitals = resources.getStringArray(R.array.hospitals)
        val arrayAdapter = ArrayAdapter(this, R.layout.dropdown_item, hospitals)
        binding.autoCompleteTextView.setAdapter(arrayAdapter)


        binding.btnPutPhoto.setOnClickListener {
            val intent = Intent(Intent.ACTION_GET_CONTENT)
            intent.type = "image/*"
            startActivityForResult(intent, Constant.GET_IMAGE_FILE)
        }

        binding.btnRegister.setOnClickListener {
            intent = Intent(this, PleaseWaitActivity::class.java)
            startActivity(intent)
        }

        getImages()

        supportActionBar?.title = getString(R.string.title_preference)

    }


    fun getImages(){
        val byteArray = intent.getByteArrayExtra(RESULT_IMAGE)
        if (byteArray != null){
            val bmp = BitmapFactory.decodeByteArray(byteArray,0, byteArray.size)
            binding.imageView.setImageDrawable(BitmapDrawable(applicationContext.resources, bmp))
            binding.btnPutPhoto.visibility = View.GONE
        }
            binding.btnPutPhoto.visibility = View.VISIBLE
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (data != null){
            binding.imageView.setImageURI(data.data)
        }
    }

}