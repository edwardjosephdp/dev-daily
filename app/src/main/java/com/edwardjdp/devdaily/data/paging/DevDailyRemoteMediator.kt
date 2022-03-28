package com.edwardjdp.devdaily.data.paging

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.edwardjdp.devdaily.data.local.LocalDataSource
import com.edwardjdp.devdaily.data.model.Article
import com.edwardjdp.devdaily.data.model.ArticleRemoteKeys
import com.edwardjdp.devdaily.data.remote.RemoteDataSource
import com.edwardjdp.devdaily.utils.AppConstants.Parameters.PER_PAGE

@ExperimentalPagingApi
class DevDailyRemoteMediator constructor(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource
) : RemoteMediator<Int, Article>() {

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, Article>
    ): MediatorResult {
        return try {
            val currentPage = when (loadType) {
                LoadType.REFRESH -> {
                    val remoteKeys = getRemoteKeyClosestToCurrentPosition(state)
                    remoteKeys?.nextPage?.minus(1) ?: 1
                }
                LoadType.PREPEND -> {
                    val remoteKeys = getRemoteKeyForFirstItem(state)
                    val prevPage = remoteKeys?.prevPage
                        ?: return MediatorResult.Success(
                            endOfPaginationReached = remoteKeys != null
                        )
                    prevPage
                }
                LoadType.APPEND -> {
                    val remoteKeys = getRemoteKeyForLastItem(state)
                    val nextPage = remoteKeys?.nextPage
                        ?: return MediatorResult.Success(
                            endOfPaginationReached = remoteKeys != null
                        )
                    nextPage
                }
            }

            val response = remoteDataSource.getLatestArticles(page = currentPage, perPage = PER_PAGE)
            val endOfPaginationReached = response.isEmpty()

            val prevPage = if (currentPage == 1) null else currentPage - 1
            val nextPage = if (endOfPaginationReached) null else currentPage + 1

            localDataSource.withTransaction {
                if (loadType == LoadType.REFRESH) {
                    localDataSource.deleteArticles()
                    localDataSource.deleteAllRemoteKeys()
                }

                val keys = response.map { article ->
                    ArticleRemoteKeys(
                        id = article.id,
                        prevPage = prevPage,
                        nextPage = nextPage
                    )
                }
                localDataSource.addAllRemoteKeys(remoteKeys = keys)
                localDataSource.addArticles(articles = response)
            }
            MediatorResult.Success(endOfPaginationReached = endOfPaginationReached)
        } catch (e: Exception) {
            return MediatorResult.Error(e)
        }
    }

    private suspend fun getRemoteKeyClosestToCurrentPosition(
        state: PagingState<Int, Article>
    ): ArticleRemoteKeys? {
        return state.anchorPosition?.let { position ->
            state.closestItemToPosition(position)?.id?.let { id ->
                localDataSource.getRemoteKeys(id = id)
            }
        }
    }

    private suspend fun getRemoteKeyForFirstItem(
        state: PagingState<Int, Article>
    ): ArticleRemoteKeys? {
        return state.pages.firstOrNull { it.data.isNotEmpty() }?.data?.firstOrNull()
            ?.let { article ->
                localDataSource.getRemoteKeys(id = article.id)
            }
    }

    private suspend fun getRemoteKeyForLastItem(
        state: PagingState<Int, Article>
    ): ArticleRemoteKeys? {
        return state.pages.lastOrNull { it.data.isNotEmpty() }?.data?.lastOrNull()
            ?.let { article ->
                localDataSource.getRemoteKeys(id = article.id)
            }
    }
}
