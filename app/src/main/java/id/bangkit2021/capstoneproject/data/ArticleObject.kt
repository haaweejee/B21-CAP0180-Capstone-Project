package id.bangkit2021.capstoneproject.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ArticleObject(
    var id: Int,
    var articleName: String,
    var articleSource: String,
    var articleContent: String,
    var articleImageUrl: String,
    var articleEditor: String,
    var articleWriter: String
) : Parcelable
