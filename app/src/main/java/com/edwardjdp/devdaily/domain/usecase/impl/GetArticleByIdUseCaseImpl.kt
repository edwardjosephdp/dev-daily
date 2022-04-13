package com.edwardjdp.devdaily.domain.usecase.impl

import com.edwardjdp.common.Resource
import com.edwardjdp.devdaily.di.IoDispatcher
import com.edwardjdp.devdaily.domain.model.ArticleUI
import com.edwardjdp.devdaily.domain.repository.ArticlesRepository
import com.edwardjdp.devdaily.domain.usecase.GetArticleByIdUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetArticleByIdUseCaseImpl @Inject constructor(
    private val repository: ArticlesRepository,
    @IoDispatcher private val dispatcher: CoroutineDispatcher
) : GetArticleByIdUseCase {

    override suspend fun invoke(id: Int): Flow<Resource<ArticleUI>> {
        return repository.getArticleById(id).flowOn(dispatcher)
    }
}
