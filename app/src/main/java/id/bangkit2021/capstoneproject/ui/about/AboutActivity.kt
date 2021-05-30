package id.bangkit2021.capstoneproject.ui.about

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import id.bangkit2021.capstoneproject.R
import id.bangkit2021.capstoneproject.databinding.ActivityAboutBinding

class AboutActivity : AppCompatActivity() {

    private lateinit var binding : ActivityAboutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sectionPagerAdapter = SectionPagerAdapter(this, supportFragmentManager)

        supportActionBar?.title = getString(R.string.about_tumor)

        binding.viewPager.adapter = sectionPagerAdapter
        binding.tabs.setupWithViewPager(binding.viewPager)
    }
}