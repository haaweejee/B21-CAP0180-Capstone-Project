package id.bangkit2021.capstoneproject.ui.article

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import id.bangkit2021.capstoneproject.data.ArticleObject
import id.bangkit2021.capstoneproject.databinding.ArticleCardBinding

class ArticleAdapter : RecyclerView.Adapter<ArticleAdapter.ViewHolder>() {
    private var listArticle = ArrayList<ArticleObject>()

    //Is for set List Article
    fun setArticle(article: List<ArticleObject>) {
        this.listArticle.clear()
        this.listArticle.addAll(article)
    }

    //Is for set Search Article
    fun searchArticle(article : ArrayList<ArticleObject>){
        this.listArticle = article
        Log.d("Search Result : ", article.toString())
        notifyDataSetChanged()
    }

    //Set Class Viewholder with viewBinding
    class ViewHolder(private val binding: ArticleCardBinding) :
        RecyclerView.ViewHolder(binding.root) {
        //this function gonna set list with title, content, image and when we click item, we go to detail Page
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

    //set List Binding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ArticleCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    //set bind position
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val article = listArticle[position]
        holder.bindArticle(article)
    }

    //set item size count
    override fun getItemCount(): Int = listArticle.size
}