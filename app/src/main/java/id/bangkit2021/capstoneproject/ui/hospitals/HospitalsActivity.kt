package id.bangkit2021.capstoneproject.ui.hospitals

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.google.firebase.firestore.FirebaseFirestore
import id.bangkit2021.capstoneproject.R
import id.bangkit2021.capstoneproject.data.HospitalsObject
import id.bangkit2021.capstoneproject.databinding.ActivityHospitalsBinding
import id.bangkit2021.capstoneproject.ui.home.HomeViewModel

class HospitalsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHospitalsBinding
    private lateinit var hospitalsAdapter: HospitalsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHospitalsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadHospitals()
        supportActionBar?.title = getString(R.string.title_hospitals)
    }

    private fun loadHospitals() {
        val hospitalsViewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        )[HomeViewModel::class.java]
        val hospitals = hospitalsViewModel.getHospitalsData()
        hospitalsAdapter = HospitalsAdapter()
        hospitalsAdapter.setHospitals(hospitals)
        with(binding.rvHospitals) {
            layoutManager = GridLayoutManager(this@HospitalsActivity, 2)
            adapter = hospitalsAdapter
        }

        binding.searchBar.queryHint = "Cari Rumah Sakit"
        binding.searchBar.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText != null){
                    val newList = hospitals.filter {
                        it.hospitalsName.contains(newText, true)
                    }
                    hospitalsAdapter.searchHospitals(newList as ArrayList<HospitalsObject>)
                }
                return true
            }

        })
    }
}