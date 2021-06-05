package id.bangkit2021.capstoneproject.ui.pleasewait

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import id.bangkit2021.capstoneproject.ui.MainActivity
import id.bangkit2021.capstoneproject.databinding.ActivityPleaseWaitBinding

class PleaseWaitActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPleaseWaitBinding
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