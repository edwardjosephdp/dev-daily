package com.edwardjdp.devdaily.data.mapper

import com.edwardjdp.common.Mapper
import com.edwardjdp.devdaily.data.model.ArticleDetails
import com.edwardjdp.devdaily.domain.model.ArticleUI
import com.edwardjdp.devdaily.domain.model.User
import javax.inject.Inject

class ApiToDomainArticleDetailsMapper @Inject constructor() : Mapper<ArticleDetails, ArticleUI> {

    override fun from(i: ArticleDetails): ArticleUI {
        return with(i) {
            ArticleUI(
                id = id,
                type = typeOf,
                title = title,
                description = description,
                coverImage = coverImage,
                path = path,
                headerImageUrl = user.profileImage90,
                tags = tagList.split(","),
                user = User(
                    name = user.name,
                    userName = user.username,
                    githubUserName = user.githubUsername,
                    image90Url = user.profileImage90,
                    image640Url = user.profileImage
                ),
                positiveReactionsCount = positiveReactionsCount,
                publicReactionsCount = publicReactionsCount,
                readingTimeMinutes = readingTimeMinutes,
                body = bodyMarkdown,
                readablePublishDate = readablePublishDate,
                publishedTimestamp = publishedTimestamp
            )
        }
    }
}
