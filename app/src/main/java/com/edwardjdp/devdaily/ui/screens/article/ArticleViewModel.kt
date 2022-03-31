package com.edwardjdp.devdaily.ui.screens.article

import androidx.lifecycle.SavedStateHandle
import com.edwardjdp.common.Resource
import com.edwardjdp.devdaily.domain.usecase.GetArticleByIdUseCase
import com.edwardjdp.devdaily.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import com.edwardjdp.devdaily.ui.screens.article.ArticleContract.ArticleEvent
import com.edwardjdp.devdaily.ui.screens.article.ArticleContract.ArticleState
import com.edwardjdp.devdaily.ui.screens.article.ArticleContract.ArticleEffect
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

@HiltViewModel
class ArticleViewModel @Inject constructor(
    private val getArticleByIdUseCase: GetArticleByIdUseCase,
    savedStateHandle: SavedStateHandle
) : BaseViewModel<ArticleEvent, ArticleState, ArticleEffect>() {

    private val articleId = savedStateHandle.get<Int>("articleId") ?: 1

    override fun createInitialState(): ArticleState = ArticleState.initial()

    override suspend fun processEvent(event: ArticleEvent) {
        when (event) {
            is ArticleEvent.LoadArticleDetails -> loadArticleById(articleId)
            ArticleEvent.RetryLoading -> loadArticleById(articleId)
        }
    }

    fun loadInitially() {
        setEvent(ArticleEvent.LoadArticleDetails)
    }

    fun retryLoading() {
        setEvent(ArticleEvent.RetryLoading)
    }

    private suspend fun loadArticleById(id: Int) {
        getArticleByIdUseCase(id)
            .onStart { emit(Resource.Loading) }
            .collect { resource ->
                when (resource) {
                    Resource.Idle -> TODO()
                    Resource.Loading -> {
                        setState {
                            copy(isLoading = true)
                        }
                    }
                    is Resource.Success -> {
                        setState {
                            copy(
                                isLoading = false,
                                data = resource.data
                            )
                        }
                    }
                    is Resource.Error -> {
                        setState {
                            copy(
                                isLoading = false,
                                data = null,
                                errorMessage = resource.exception.message
                            )
                        }
                        setEffect {
                            ArticleEffect.OnError(resource.exception)
                        }
                    }
                }
            }

    }
}