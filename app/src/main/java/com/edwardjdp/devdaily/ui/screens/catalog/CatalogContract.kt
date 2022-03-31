package com.edwardjdp.devdaily.ui.screens.catalog

import androidx.paging.PagingData
import com.edwardjdp.devdaily.domain.model.ArticleUI
import com.edwardjdp.common.UiEffect
import com.edwardjdp.common.UiEvent
import com.edwardjdp.common.UiState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow


object CatalogContract {

    sealed class CatalogEvent : UiEvent {
        object LoadLatestArticles : CatalogEvent()
        object RetryLoading : CatalogEvent()
        data class SelectArticle(val id: Int) : CatalogEvent()
    }

    data class CatalogState(
        val data: Flow<PagingData<ArticleUI>>
    ) : UiState {
        companion object {
            fun initial(): CatalogState = CatalogState(data = emptyFlow())
        }
    }

    sealed class CatalogEffect : UiEffect {
        data class OnArticleSelected(val articleId: Int) : CatalogEffect()
    }
}
