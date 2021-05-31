package id.bangkit2021.capstoneproject.ui.hospitals

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import id.bangkit2021.capstoneproject.R
import id.bangkit2021.capstoneproject.data.HospitalsObject
import id.bangkit2021.capstoneproject.databinding.ActivityHospitalDetailBinding

class HospitalDetailActivity : AppCompatActivity() {

    companion object{
        const val HOSPITALS = "hospitals"
    }


    private lateinit var binding: ActivityHospitalDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHospitalDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val hospitals = intent.getParcelableExtra<HospitalsObject>(HOSPITALS)

        supportActionBar?.title = hospitals?.hospitalsName
        binding.hospitalAddress.text = hospitals?.hospitalsAddress
        binding.hospitaltelphone.text = hospitals?.hospitalsTelephone

        Glide.with(this)
            .load(hospitals?.hospitalsPhotoUrl)
            .into(binding.imageHospitals)



    }
}