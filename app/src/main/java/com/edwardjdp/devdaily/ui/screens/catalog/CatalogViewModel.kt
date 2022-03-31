package com.edwardjdp.devdaily.ui.screens.catalog

import androidx.paging.ExperimentalPagingApi
import com.edwardjdp.devdaily.domain.usecase.GetLatestArticlesUseCase
import com.edwardjdp.devdaily.ui.base.BaseViewModel
import com.edwardjdp.devdaily.ui.screens.catalog.CatalogContract.CatalogEvent
import com.edwardjdp.devdaily.ui.screens.catalog.CatalogContract.CatalogState
import com.edwardjdp.devdaily.ui.screens.catalog.CatalogContract.CatalogEffect
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@ExperimentalPagingApi
@HiltViewModel
class CatalogViewModel @Inject constructor(
    private val getLatestArticlesUseCase: GetLatestArticlesUseCase
) : BaseViewModel<CatalogEvent, CatalogState, CatalogEffect>() {

    init {
        loadArticles()
    }

    override fun createInitialState(): CatalogState = CatalogState.initial()

    override suspend fun processEvent(event: CatalogEvent) {
        when (event) {
            CatalogEvent.LoadLatestArticles -> getAllLatestArticles()
            CatalogEvent.RetryLoading -> TODO()
            is CatalogEvent.SelectArticle -> selectArticle(event.id)
        }
    }

    fun loadArticles() {
        setEvent(CatalogEvent.LoadLatestArticles)
    }

    fun viewArticle(id: Int) {
        setEvent(CatalogEvent.SelectArticle(id))
    }

    private suspend fun getAllLatestArticles() {
        val latestArticles = getLatestArticlesUseCase()
        setState {
            copy(data = latestArticles)
        }
    }

    private fun selectArticle(id: Int) {
        setEffect {
            CatalogEffect.OnArticleSelected(id)
        }
    }
}