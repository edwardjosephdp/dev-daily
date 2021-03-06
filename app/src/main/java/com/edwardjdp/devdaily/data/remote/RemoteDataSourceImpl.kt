package com.edwardjdp.devdaily.data.remote

import com.edwardjdp.devdaily.data.model.Article
import com.edwardjdp.devdaily.data.model.ArticleDetails
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(
    private val service: DevDailyApi
) : RemoteDataSource {

    override suspend fun getLatestArticles(page: Int, perPage: Int): List<Article> {
        return service.getLatestArticles(page, perPage)
    }

    override suspend fun fetchArticleById(id: Int): ArticleDetails {
        return service.fetchArticleById(id)
    }
}
