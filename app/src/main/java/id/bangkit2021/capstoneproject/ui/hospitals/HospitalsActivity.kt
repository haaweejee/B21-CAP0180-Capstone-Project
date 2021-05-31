package id.bangkit2021.capstoneproject.ui.hospitals

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import id.bangkit2021.capstoneproject.databinding.ActivityHospitalsBinding
import id.bangkit2021.capstoneproject.ui.home.HomeViewModel

class HospitalsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHospitalsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHospitalsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadHospitals()
    }

    private fun loadHospitals(){
        val hospitalsViewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[HomeViewModel::class.java]
        val hospitals = hospitalsViewModel.getHospitalsData()
        val hospitalsAdapter = HospitalsAdapter()
        hospitalsAdapter.setHospitals(hospitals)
        with(binding.rvHospitals){
            layoutManager = GridLayoutManager(this@HospitalsActivity,2)
            setHasFixedSize(true)
            adapter = hospitalsAdapter
        }
    }
}