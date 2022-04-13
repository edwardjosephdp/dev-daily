package com.edwardjdp.devdaily.ui.screens.catalog

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.paging.ExperimentalPagingApi
import androidx.paging.compose.collectAsLazyPagingItems
import com.edwardjdp.devdaily.R
import com.edwardjdp.devdaily.ui.screens.common.ListContent
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach

@ExperimentalPagingApi
@Composable
fun CatalogScreen(
    navController: NavHostController,
    viewModel: CatalogViewModel = hiltViewModel()
) {
    val state = viewModel.uiState.collectAsState()
    val effectFlow = viewModel.effect

    LaunchedEffect(effectFlow) {
        effectFlow.onEach { effect ->
            when (effect) {
                is CatalogContract.CatalogEffect.OnArticleSelected -> navController.navigate("article_screen/${effect.articleId}")
            }
        }.collect()
    }

    Scaffold(
        topBar = {
            CatalogTopBar(stringResource(id = R.string.app_name))
        },
        content = {
            ListContent(state.value.data.collectAsLazyPagingItems(), viewModel)
        }
    )
}
