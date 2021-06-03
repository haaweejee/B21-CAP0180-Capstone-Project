package id.bangkit2021.capstoneproject.ui.article

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import id.bangkit2021.capstoneproject.data.ArticleObject
import id.bangkit2021.capstoneproject.databinding.ActivityDetailArticleBinding

class DetailArticleActivity : AppCompatActivity() {

    //This for get Data From ArticleActivity
    companion object {
        const val ARTICLE = "article"
    }

    //Variable Binding
    private lateinit var binding: ActivityDetailArticleBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Set Binding
        binding = ActivityDetailArticleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Get intent Parceable
        val article = intent.getParcelableExtra<ArticleObject>(ARTICLE)

        //set Article name, Content and image
        binding.articleName.text = article?.articleName
        binding.articleContent.text = article?.articleContent
        Glide.with(this)
            .load(article?.articleImageUrl)
            .into(binding.articlePhoto)
    }
}