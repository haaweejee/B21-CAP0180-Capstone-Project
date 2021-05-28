package id.bangkit2021.capstoneproject.ui

import android.content.Intent
import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import id.bangkit2021.capstoneproject.MainActivity
import id.bangkit2021.capstoneproject.R
import java.util.*
import kotlin.concurrent.schedule

class SplashscreenActivity : AppCompatActivity() {

    private val timer = Timer()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashscreen)


        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        supportActionBar?.hide()
        timer.schedule(DELAY){
            val intent = Intent(this@SplashscreenActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

    }

    override fun onPause() {
        timer.cancel()
        super.onPause()
    }

    companion object{
        const val DELAY = 1000L
    }
}