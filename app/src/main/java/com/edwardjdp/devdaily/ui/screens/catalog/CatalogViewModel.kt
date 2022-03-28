package com.edwardjdp.devdaily.ui.screens.catalog

import androidx.lifecycle.viewModelScope
import androidx.paging.ExperimentalPagingApi
import androidx.paging.PagingData
import com.edwardjdp.devdaily.domain.model.ArticleUI
import com.edwardjdp.devdaily.domain.repository.ArticlesRepository
import com.edwardjdp.devdaily.domain.usecase.GetLatestArticles
import com.edwardjdp.devdaily.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@ExperimentalPagingApi
@HiltViewModel
class CatalogViewModel @Inject constructor(
    private val getLatestArticles: GetLatestArticles
) : BaseViewModel<CatalogContract.CatalogEvent, CatalogContract.CatalogState, CatalogContract.CatalogEffect>() {

    init {
        loadInitialContent()
    }

    override fun createInitialState(): CatalogContract.CatalogState {
        return CatalogContract.CatalogState.Idle
    }

    override fun handleEvent(event: CatalogContract.CatalogEvent) {
        when (event) {
            CatalogContract.CatalogEvent.LoadInitialArticles -> getAllLatestArticles()
            CatalogContract.CatalogEvent.RetryLoading -> TODO()
            is CatalogContract.CatalogEvent.SelectArticle -> TODO()
        }
    }

    fun loadInitialContent() {
        setEvent(CatalogContract.CatalogEvent.LoadInitialArticles)
    }

    private fun getAllLatestArticles() {
        setPagingData {
            getLatestArticles()
        }
    }
}