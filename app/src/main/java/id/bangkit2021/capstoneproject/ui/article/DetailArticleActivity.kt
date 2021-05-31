package id.bangkit2021.capstoneproject.ui.article

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import id.bangkit2021.capstoneproject.R
import id.bangkit2021.capstoneproject.data.ArticleObject
import id.bangkit2021.capstoneproject.databinding.ActivityDetailArticleBinding

class DetailArticleActivity : AppCompatActivity() {

    companion object{
        const val ARTICLE = "article"
    }

    private lateinit var binding : ActivityDetailArticleBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailArticleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val article = intent.getParcelableExtra<ArticleObject>(ARTICLE)

        binding.articleName.text = article?.articleName
        binding.articleContent.text = article?.articleContent
        Glide.with(this)
            .load(article?.articleImageUrl)
            .into(binding.articlePhoto)
    }
}