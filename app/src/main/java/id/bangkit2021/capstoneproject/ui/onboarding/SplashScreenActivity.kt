package id.bangkit2021.capstoneproject.ui.onboarding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.bangkit2021.capstoneproject.R

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        supportActionBar?.hide()
    }
}