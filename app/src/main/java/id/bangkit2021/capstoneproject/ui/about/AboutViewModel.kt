package id.bangkit2021.capstoneproject.ui.about

import androidx.lifecycle.ViewModel
import id.bangkit2021.capstoneproject.data.AboutDummy
import id.bangkit2021.capstoneproject.data.AboutObject

class AboutViewModel : ViewModel() {
    //Call Dummy Data to ViewModel
    fun getAboutData(): List<AboutObject> = AboutDummy.generateAboutData()
}