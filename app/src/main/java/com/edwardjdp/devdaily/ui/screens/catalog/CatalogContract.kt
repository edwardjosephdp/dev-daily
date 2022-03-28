package com.edwardjdp.devdaily.ui.screens.catalog

import androidx.paging.PagingData
import com.edwardjdp.devdaily.domain.model.ArticleUI
import com.edwardjdp.devdaily.ui.base.UiEffect
import com.edwardjdp.devdaily.ui.base.UiEvent
import com.edwardjdp.devdaily.ui.base.UiState
import kotlinx.coroutines.flow.Flow


object CatalogContract {

    sealed class CatalogEvent : UiEvent {
        object LoadInitialArticles : CatalogEvent()
        object RetryLoading : CatalogEvent()
        data class SelectArticle(val id: Int) : CatalogEvent()
    }

    sealed class CatalogState : UiState {
        object Idle : CatalogState()
        data class FetchSuccess(val data: Flow<PagingData<ArticleUI>>) : CatalogState()
    }

    sealed class CatalogEffect : UiEffect {
        data class ShowError(val message: String) : CatalogEffect()
        data class OnArticleSelected(val articleId: Int) : CatalogState()
    }
}
