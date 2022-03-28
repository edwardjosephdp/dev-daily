package com.edwardjdp.devdaily.data.local

import androidx.paging.PagingSource
import com.edwardjdp.devdaily.data.model.Article
import com.edwardjdp.devdaily.data.model.ArticleRemoteKeys

interface LocalDataSource {

    fun getLatestArticles(): PagingSource<Int, Article>

    suspend fun addArticles(articles: List<Article>)

    suspend fun deleteArticles()

    suspend fun getRemoteKeys(id: Int): ArticleRemoteKeys

    suspend fun addAllRemoteKeys(remoteKeys: List<ArticleRemoteKeys>)

    suspend fun deleteAllRemoteKeys()

    suspend fun withTransaction(block: suspend () -> Unit): Unit

    fun getDatabase(): DevDailyDb
}
