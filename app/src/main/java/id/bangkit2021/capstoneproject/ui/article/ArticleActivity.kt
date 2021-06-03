package id.bangkit2021.capstoneproject.ui.article

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import id.bangkit2021.capstoneproject.R
import id.bangkit2021.capstoneproject.data.ArticleObject
import id.bangkit2021.capstoneproject.databinding.ActivityArticleBinding
import id.bangkit2021.capstoneproject.ui.home.HomeViewModel

class ArticleActivity : AppCompatActivity() {

    //Variable Binding
    private lateinit var binding: ActivityArticleBinding
    //Variable Article
    private lateinit var articleAdapter: ArticleAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //set Binding
        binding = ActivityArticleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Call loadArticleFunction
        loadArticleData()

        //set Title Action Bar
        supportActionBar?.title = getString(R.string.title_article)
    }

    private fun loadArticleData() {
        //Call HomeViewModel
        val articleViewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        )[HomeViewModel::class.java]
        val articles = articleViewModel.getArticleData()

        //Inizialize and set the item at Adapter
        articleAdapter = ArticleAdapter()
        articleAdapter.setArticle(articles)

        //set List to Linear
        with(binding.rvArticle) {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = articleAdapter
        }

        //set hint for seachbar
        binding.searchBar.queryHint = "Cari Article"

        //set Searchbar
        binding.searchBar.setOnQueryTextListener(object :androidx.appcompat.widget.SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            //When character input list gonna change
            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText != null){
                    //Filter the character
                    val newList = articles.filter {
                        it.articleName.contains(newText, true)
                    }
                    //set List for new Character
                    articleAdapter.searchArticle(newList as ArrayList<ArticleObject>)
                }
                return true
            }
        })
    }
}