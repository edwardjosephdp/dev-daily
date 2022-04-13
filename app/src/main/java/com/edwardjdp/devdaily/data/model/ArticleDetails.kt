package com.edwardjdp.devdaily.data.model

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class ArticleDetails(
    @SerializedName("body_html")
    val bodyHtml: String,
    @SerializedName("body_markdown")
    val bodyMarkdown: String,
    @SerializedName("canonical_url")
    val canonicalUrl: String,
    @SerializedName("collection_id")
    val collectionId: Any,
    @SerializedName("comments_count")
    val commentsCount: Int,
    @SerializedName("cover_image")
    val coverImage: String,
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("crossposted_at")
    val crosspostedAt: Any,
    @SerializedName("description")
    val description: String,
    @SerializedName("edited_at")
    val editedAt: Any,
    @SerializedName("id")
    val id: Int,
    @SerializedName("last_comment_at")
    val lastCommentAt: String,
    @SerializedName("path")
    val path: String,
    @SerializedName("positive_reactions_count")
    val positiveReactionsCount: Int,
    @SerializedName("public_reactions_count")
    val publicReactionsCount: Int,
    @SerializedName("published_at")
    val publishedAt: String,
    @SerializedName("published_timestamp")
    val publishedTimestamp: String,
    @SerializedName("readable_publish_date")
    val readablePublishDate: String,
    @SerializedName("reading_time_minutes")
    val readingTimeMinutes: Int,
    @SerializedName("slug")
    val slug: String,
    @SerializedName("social_image")
    val socialImage: String,
    @SerializedName("tag_list")
    val tagList: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("type_of")
    val typeOf: String,
    @SerializedName("url")
    val url: String,
    @SerializedName("user")
    val user: User
)
