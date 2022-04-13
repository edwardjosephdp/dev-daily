package com.edwardjdp.devdaily.data.model

import androidx.annotation.Keep
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.edwardjdp.devdaily.utils.AppConstants.ARTICLES_TABLE
import com.google.gson.annotations.SerializedName

@Keep
@Entity(tableName = ARTICLES_TABLE)
data class Article(
    @PrimaryKey(autoGenerate = true)
    val dId: Int,
    @SerializedName("id")
    val id: Int,
    @SerializedName("cover_image")
    val coverImage: String?,
    @SerializedName("description")
    val description: String,
    @SerializedName("path")
    val path: String,
    @SerializedName("positive_reactions_count")
    val positiveReactionsCount: Int,
    @SerializedName("public_reactions_count")
    val publicReactionsCount: Int,
    @SerializedName("published_timestamp")
    val publishedTimestamp: String,
    @SerializedName("readable_publish_date")
    val readablePublishDate: String,
    @SerializedName("reading_time_minutes")
    val readingTimeMinutes: Int,
    @SerializedName("social_image")
    val socialImage: String,
    @SerializedName("tags")
    val tagList: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("type_of")
    val typeOf: String,
    @SerializedName("url")
    val url: String,
    @SerializedName("user")
    @Embedded
    val user: User
)
