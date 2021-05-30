package id.bangkit2021.capstoneproject.ui.home

import androidx.lifecycle.ViewModel
import id.bangkit2021.capstoneproject.data.HospitalsDummy
import id.bangkit2021.capstoneproject.data.HospitalsObject

class HomeViewModel : ViewModel() {

    fun getHospitalsData() : List<HospitalsObject> = HospitalsDummy.generateHospitalsData()

}