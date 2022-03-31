package com.edwardjdp.devdaily.domain.usecase

import com.edwardjdp.common.Resource
import com.edwardjdp.devdaily.domain.model.ArticleUI
import kotlinx.coroutines.flow.Flow

interface GetArticleByIdUseCase {
    suspend operator fun invoke(id: Int): Flow<Resource<ArticleUI>>
}