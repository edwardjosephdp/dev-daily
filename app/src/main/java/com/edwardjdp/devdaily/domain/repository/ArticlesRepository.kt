package com.edwardjdp.devdaily.domain.repository

import androidx.paging.PagingData
import com.edwardjdp.common.Resource
import com.edwardjdp.devdaily.domain.model.ArticleUI
import kotlinx.coroutines.flow.Flow

interface ArticlesRepository {

    fun getLatestArticles() : Flow<PagingData<ArticleUI>>

    suspend fun getArticleById() : ArticleUI
}
