package com.edwardjdp.devdaily.data.local

import androidx.paging.PagingSource
import androidx.room.withTransaction
import com.edwardjdp.common.Mapper
import com.edwardjdp.devdaily.data.model.Article
import com.edwardjdp.devdaily.data.model.ArticleRemoteKeys
import com.edwardjdp.devdaily.domain.model.ArticleUI
import javax.inject.Inject

class LocalDataSourceImpl @Inject constructor(
    private val database: DevDailyDb
) : LocalDataSource {

    override fun getLatestArticles(): PagingSource<Int, Article> {
        return database.articleDao().getLatestArticles()
    }

    override suspend fun addArticles(articles: List<Article>) {
        return database.articleDao().addArticles(articles)
    }

    override suspend fun deleteArticles() {
        return database.articleDao().deleteArticles()
    }

    override suspend fun getRemoteKeys(id: Int): ArticleRemoteKeys {
        return database.articleRemoteKeysDao().getRemoteKeys(id)
    }

    override suspend fun addAllRemoteKeys(remoteKeys: List<ArticleRemoteKeys>) {
        return database.articleRemoteKeysDao().addAllRemoteKeys(remoteKeys)
    }

    override suspend fun deleteAllRemoteKeys() {
        return database.articleRemoteKeysDao().deleteAllRemoteKeys()
    }

    override suspend fun withTransaction(block: suspend () -> Unit) {
        return database.withTransaction(block)
    }

    override fun getDatabase(): DevDailyDb {
        return database
    }
}