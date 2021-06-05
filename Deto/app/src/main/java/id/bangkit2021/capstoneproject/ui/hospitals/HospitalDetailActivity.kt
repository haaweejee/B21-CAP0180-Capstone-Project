package id.bangkit2021.capstoneproject.ui.hospitals

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import id.bangkit2021.capstoneproject.data.HospitalsObject
import id.bangkit2021.capstoneproject.databinding.ActivityHospitalDetailBinding

class HospitalDetailActivity : AppCompatActivity() {

    companion object {
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

        binding.btnRute.setOnClickListener {
            Toast.makeText(this, "Fitur sedang dikembangkan", Toast.LENGTH_SHORT).show()
        }

        binding.btnWeb.setOnClickListener {
            intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(hospitals?.hospitalsWeb)
            startActivity(intent)
        }

        binding.btnTelphone.setOnClickListener {
            intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + hospitals?.hospitalsTelephone))
            startActivity(intent)
        }
    }


}