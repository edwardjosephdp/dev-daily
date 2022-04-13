package com.edwardjdp.devdaily.domain.usecase

import androidx.paging.PagingData
import com.edwardjdp.devdaily.domain.model.ArticleUI
import kotlinx.coroutines.flow.Flow

interface GetLatestArticlesUseCase {
    suspend operator fun invoke(): Flow<PagingData<ArticleUI>>
}
