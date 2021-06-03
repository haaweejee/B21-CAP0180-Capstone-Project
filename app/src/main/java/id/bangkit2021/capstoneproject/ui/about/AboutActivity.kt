package id.bangkit2021.capstoneproject.ui.about

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import id.bangkit2021.capstoneproject.R
import id.bangkit2021.capstoneproject.databinding.ActivityAboutBinding

class AboutActivity : AppCompatActivity() {
    //Binding Variable
    private lateinit var binding: ActivityAboutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //set Binding
        binding = ActivityAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Init SectionPager
        val sectionPagerAdapter = SectionPagerAdapter(this, supportFragmentManager)

        //setActionbar to "Tentang Tumor"
        supportActionBar?.title = getString(R.string.about_tumor)

        //set tabsLayout
        binding.viewPager.adapter = sectionPagerAdapter
        binding.tabs.setupWithViewPager(binding.viewPager)
    }
}