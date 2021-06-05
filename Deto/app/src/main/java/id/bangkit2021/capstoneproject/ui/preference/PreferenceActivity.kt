@file:Suppress("DEPRECATION")

package id.bangkit2021.capstoneproject.ui.preference

import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.FirebaseFirestore
import id.bangkit2021.capstoneproject.ui.pleasewait.PleaseWaitActivity
import id.bangkit2021.capstoneproject.R
import id.bangkit2021.capstoneproject.databinding.ActivityPreferenceBinding
import id.bangkit2021.capstoneproject.utils.Constant

class PreferenceActivity : AppCompatActivity() {

    companion object {
        const val RESULT_IMAGE = "bitmapImage"
    }

    private lateinit var binding: ActivityPreferenceBinding
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
            val pasienName = binding.edtName.text.toString()
            val email = binding.edtEmail.text.toString()
            val phone = binding.edtPhone.text.toString()

            val nameSibling = binding.edtNameSibling.text.toString()
            val reason = binding.edtReason.text.toString()
            val hospitals = binding.autoCompleteTextView.text.toString()

            val db = FirebaseFirestore.getInstance()
            val user = hashMapOf(
                "name" to pasienName,
                "email" to email,
                "phone" to phone,
                "sibling" to nameSibling,
                "reason" to reason,
                "hospitals" to hospitals
            )

            loadingBar(true)
            db.collection("users")
                .add(user)
                .addOnSuccessListener {
                    val intent = Intent(this, PleaseWaitActivity::class.java)
                    startActivity(intent)
                    finish()
                    Log.d("Success", "Data Berhasil Dikirim")
                }
                .addOnFailureListener {
                    loadingBar(false)
                    finish()
                    Toast.makeText(this, "Data Gagal Dikirim", Toast.LENGTH_SHORT).show()
                    Log.d("Fail", "Data Gagal Dikirim")

                }

        }


        getImages()

        supportActionBar?.title = getString(R.string.title_preference)

    }


    private fun getImages() {
        val byteArray = intent.getByteArrayExtra(RESULT_IMAGE)
        if (byteArray != null) {
            val bmp = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.size)
            binding.imageView.setImageDrawable(BitmapDrawable(applicationContext.resources, bmp))
            binding.btnPutPhoto.visibility = View.GONE
        }
        binding.btnPutPhoto.visibility = View.VISIBLE
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (data != null) {
            binding.imageView.setImageURI(data.data)
        }
    }

    private fun loadingBar(state: Boolean){
        if (state){
            binding.loadingBar.visibility = View.VISIBLE
        }else{
            binding.loadingBar.visibility = View.GONE
        }
    }


}