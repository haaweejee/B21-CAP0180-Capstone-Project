package id.bangkit2021.capstoneproject.ui.loginregister

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import id.bangkit2021.capstoneproject.MainActivity
import id.bangkit2021.capstoneproject.databinding.ActivityLoginRegisterBinding

class LoginRegisterActivity : AppCompatActivity() {

    private lateinit var binding : ActivityLoginRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val loginRegisterViewPager = LoginRegisterViewPager(this, supportFragmentManager)


        binding.viewPager.adapter = loginRegisterViewPager
        binding.tabs.setupWithViewPager(binding.viewPager)
        binding.btnGoogle.setOnClickListener {
            intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        supportActionBar?.hide()
    }
}