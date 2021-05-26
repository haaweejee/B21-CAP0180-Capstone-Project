package id.bangkit2021.capstoneproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.bangkit2021.capstoneproject.databinding.ActivityPleaseWaitBinding

class PleaseWaitActivity : AppCompatActivity() {

    private lateinit var binding : ActivityPleaseWaitBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPleaseWaitBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnHome.setOnClickListener {
            intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        supportActionBar?.hide()

    }
}