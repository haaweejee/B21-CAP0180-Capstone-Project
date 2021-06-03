package id.bangkit2021.capstoneproject.ui.home

import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.FirebaseFirestore
import id.bangkit2021.capstoneproject.data.ArticleDummy
import id.bangkit2021.capstoneproject.data.ArticleObject
import id.bangkit2021.capstoneproject.data.HospitalsDummy
import id.bangkit2021.capstoneproject.data.HospitalsObject

class HomeViewModel : ViewModel()  {



    fun getHospitalsData(): List<HospitalsObject> = HospitalsDummy.generateHospitalsData()

    fun getArticleData(): List<ArticleObject> = ArticleDummy.generateDummyArticle()
}