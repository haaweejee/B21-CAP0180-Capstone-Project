package id.bangkit2021.capstoneproject.ui.article

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import id.bangkit2021.capstoneproject.R
import id.bangkit2021.capstoneproject.databinding.ActivityArticleBinding
import id.bangkit2021.capstoneproject.ui.home.HomeViewModel
import id.bangkit2021.capstoneproject.ui.home.LinearAdapter

class ArticleActivity : AppCompatActivity() {

    private lateinit var binding: ActivityArticleBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityArticleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadArticleData()
    }

    private fun loadArticleData(){
        val articleViewModel = ViewModelProvider(this,
            ViewModelProvider.NewInstanceFactory())[HomeViewModel::class.java]
        val articles = articleViewModel.getArticleData()
        val articleAdapter = ArticleAdapter()
        articleAdapter.setArticle(articles)
        with(binding.rvArticle){
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = articleAdapter
        }
    }
}