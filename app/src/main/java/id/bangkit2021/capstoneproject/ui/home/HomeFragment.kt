package id.bangkit2021.capstoneproject.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.models.SlideModel
import id.bangkit2021.capstoneproject.R
import id.bangkit2021.capstoneproject.databinding.FragmentHomeBinding
import id.bangkit2021.capstoneproject.ui.PreferenceActivity
import id.bangkit2021.capstoneproject.ui.about.AboutActivity

@Suppress("DEPRECATION")
class HomeFragment : Fragment(R.layout.fragment_home) {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentHomeBinding.bind(view)

        imageAds()
        loadHospitalsData()
        loadArticleData()
        binding.btnPreference.setOnClickListener {
            val intent = Intent(context, PreferenceActivity::class.java)
            startActivity(intent)
        }

        binding.btnAbout.setOnClickListener {
            val intent = Intent(context, AboutActivity::class.java)
            startActivity(intent)
        }
    }

    private fun loadHospitalsData(){
        val hospitalsViewModel =
            ViewModelProvider(this,
                ViewModelProvider.NewInstanceFactory())[HomeViewModel::class.java]
        val hospitals = hospitalsViewModel.getHospitalsData()
        val hospitalsAdapter = HorizontalAdapter()
        hospitalsAdapter.setHospitals(hospitals)
        with(binding.rvList){
            layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
            setHasFixedSize(true)
            adapter = hospitalsAdapter
        }
    }

    private fun loadArticleData(){
        val articleViewModel = ViewModelProvider(this,
            ViewModelProvider.NewInstanceFactory())[HomeViewModel::class.java]
        val articles = articleViewModel.getArticleData()
        val articleAdapter = LinearAdapter()
        articleAdapter.setArticle(articles)
        with(binding.rvArticle){
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = articleAdapter
        }
    }



    private fun imageAds(){
        val imageAds = ArrayList<SlideModel>()

        imageAds.add(SlideModel(R.drawable.ads_1))
        imageAds.add(SlideModel(R.drawable.ads_2))
        imageAds.add(SlideModel(R.drawable.ads_3))

        val imageSlider = activity?.findViewById<ImageSlider>(R.id.imageSlider)
        imageSlider?.setImageList(imageAds)
    }

}