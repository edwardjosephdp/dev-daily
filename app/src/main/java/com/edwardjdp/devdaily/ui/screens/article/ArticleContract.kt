package com.edwardjdp.devdaily.ui.screens.article

import com.edwardjdp.common.UiEffect
import com.edwardjdp.common.UiEvent
import com.edwardjdp.common.UiState
import com.edwardjdp.devdaily.domain.model.ArticleUI

object ArticleContract {

    sealed class ArticleEvent : UiEvent {
        object LoadArticleDetails : ArticleEvent()
        object RetryLoading : ArticleEvent()
    }

    data class ArticleState(
        val isLoading: Boolean,
        val data: ArticleUI?,
        val errorMessage: String?
    ) : UiState {
        companion object {
            fun initial(): ArticleState = ArticleState(isLoading = false, data = null, errorMessage = null)
        }
    }

    sealed class ArticleEffect : UiEffect {
        data class OnError(val exception: Exception) : ArticleEffect()
    }
}
