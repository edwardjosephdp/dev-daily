package com.edwardjdp.devdaily.data.remote

import com.edwardjdp.devdaily.utils.AppConstants.ARTICLES_ENDPOINT
import com.edwardjdp.devdaily.utils.AppConstants.ARTICLE_BY_ID_ENDPOINT
import com.edwardjdp.devdaily.data.model.Article
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface DevDailyApi {

    @GET(ARTICLES_ENDPOINT)
    suspend fun getLatestArticles(
        @Query("page") page: Int,
        @Query("per_page") perPage: Int
    ): List<Article>

    @GET(ARTICLE_BY_ID_ENDPOINT)
    suspend fun fetchArticleById(
        @Path("id") id: Int
    ): Article

}
