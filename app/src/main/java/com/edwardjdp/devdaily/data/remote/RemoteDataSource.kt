package com.edwardjdp.devdaily.data.remote

import com.edwardjdp.devdaily.data.model.Article
import com.edwardjdp.devdaily.data.model.ArticleDetails

interface RemoteDataSource {

    suspend fun getLatestArticles(page: Int, perPage: Int): List<Article>

    suspend fun fetchArticleById(id: Int): ArticleDetails
}
