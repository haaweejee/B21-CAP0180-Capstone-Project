package id.bangkit2021.capstoneproject.ui.onboarding

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import id.bangkit2021.capstoneproject.R

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        supportActionBar?.hide()
    }
}