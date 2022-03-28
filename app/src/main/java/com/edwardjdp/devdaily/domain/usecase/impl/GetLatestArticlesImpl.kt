package com.edwardjdp.devdaily.domain.usecase.impl

import androidx.paging.PagingData
import com.edwardjdp.devdaily.di.IoDispatcher
import com.edwardjdp.devdaily.domain.model.ArticleUI
import com.edwardjdp.devdaily.domain.repository.ArticlesRepository
import com.edwardjdp.devdaily.domain.usecase.GetLatestArticles
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetLatestArticlesImpl @Inject constructor(
    private val repository: ArticlesRepository,
    @IoDispatcher private val dispatcher: CoroutineDispatcher
) : GetLatestArticles {

    override suspend fun invoke(): Flow<PagingData<ArticleUI>> {
        return repository.getLatestArticles().flowOn(dispatcher)
    }
}