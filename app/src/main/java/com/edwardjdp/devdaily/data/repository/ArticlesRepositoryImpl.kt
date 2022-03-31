package com.edwardjdp.devdaily.data.repository

import androidx.paging.*
import com.edwardjdp.common.Mapper
import com.edwardjdp.common.Resource
import com.edwardjdp.devdaily.data.local.LocalDataSource
import com.edwardjdp.devdaily.data.model.Article
import com.edwardjdp.devdaily.data.model.ArticleDetails
import com.edwardjdp.devdaily.data.paging.DevDailyRemoteMediator
import com.edwardjdp.devdaily.data.remote.RemoteDataSource
import com.edwardjdp.devdaily.domain.model.ArticleUI
import com.edwardjdp.devdaily.domain.repository.ArticlesRepository
import com.edwardjdp.devdaily.utils.AppConstants.Parameters.PER_PAGE
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@ExperimentalPagingApi
class ArticlesRepositoryImpl @Inject constructor(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource,
    private val articleMapper: Mapper<Article, ArticleUI>,
    private val articleDetailsMapper: Mapper<ArticleDetails, ArticleUI>
) : ArticlesRepository {

    override fun getLatestArticles(): Flow<PagingData<ArticleUI>> {
        val pagingSourceFactory = { localDataSource.getLatestArticles() }

        return Pager(
            config = PagingConfig(pageSize = PER_PAGE),
            remoteMediator = DevDailyRemoteMediator(
                localDataSource = localDataSource,
                remoteDataSource = remoteDataSource
            ),
            pagingSourceFactory = pagingSourceFactory
        ).flow.map {
            it.map { article ->
                articleMapper.from(article)
            }
        }
    }

    override suspend fun getArticleById(id: Int): Flow<Resource<ArticleUI>> {
        return flow {
            try {
                val response = remoteDataSource.fetchArticleById(id)
                val article = articleDetailsMapper.from(response)
                emit(Resource.Success(article))
            } catch (e: Exception) {
                emit(Resource.Error(e))
            }
        }
    }
}