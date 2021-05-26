package id.bangkit2021.capstoneproject.ui

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import id.bangkit2021.capstoneproject.PleaseWaitActivity
import id.bangkit2021.capstoneproject.R
import id.bangkit2021.capstoneproject.databinding.ActivityPreferenceBinding

class PreferenceActivity : AppCompatActivity() {

    private lateinit var binding : ActivityPreferenceBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPreferenceBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val hospitals = resources.getStringArray(R.array.hospitals)
        val arrayAdapter = ArrayAdapter(this, R.layout.dropdown_item, hospitals)
        binding.autoCompleteTextView.setAdapter(arrayAdapter)

        binding.btnRegister.setOnClickListener {
            intent = Intent(this, PleaseWaitActivity::class.java)
            startActivity(intent)
        }

        supportActionBar?.title = getString(R.string.title_preference)
    }



}