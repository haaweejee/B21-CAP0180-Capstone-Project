package id.bangkit2021.capstoneproject.ui.article

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import id.bangkit2021.capstoneproject.data.ArticleObject
import id.bangkit2021.capstoneproject.databinding.ArticleCardBinding

class ArticleAdapter : RecyclerView.Adapter<ArticleAdapter.ViewHolder>() {
    private val listArticle = ArrayList<ArticleObject>()

    fun setArticle(article: List<ArticleObject>){
        this.listArticle.clear()
        this.listArticle.addAll(article)
    }

    class ViewHolder(private val binding: ArticleCardBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bindArticle(article: ArticleObject) {
            with(binding) {
                tvArticleTitle.text = article.articleName
                tvArticleContent.text = article.articleContent
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailArticleActivity::class.java)
                    intent.putExtra(DetailArticleActivity.ARTICLE, article)
                    itemView.context.startActivity(intent)
                }
                Glide.with(itemView.context)
                    .load(article.articleImageUrl)
                    .transform(RoundedCorners(20))
                    .into(imageArticle)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ArticleCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val article = listArticle[position]
        holder.bindArticle(article)
    }

    override fun getItemCount(): Int = listArticle.size
}