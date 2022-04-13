package com.edwardjdp.devdaily.domain.model

data class ArticleUI(
    val id: Int,
    val type: String,
    val title: String?,
    val description: String?,
    val coverImage: String?,
    val path: String?,
    val headerImageUrl: String?,
    val tags: List<String>,
    val user: User,
    val positiveReactionsCount: Int,
    val publicReactionsCount: Int,
    val readingTimeMinutes: Int,
    val body: String?,
    val readablePublishDate: String?,
    val publishedTimestamp: String?
)

// TODO: Enum mapping
enum class ArticleType {
    ARTICLE, VIDEO_ARTICLE, NONE
}
