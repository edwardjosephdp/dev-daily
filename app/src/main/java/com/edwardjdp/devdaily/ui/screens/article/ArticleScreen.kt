package com.edwardjdp.devdaily.ui.screens.article

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.paging.ExperimentalPagingApi
import com.edwardjdp.devdaily.R
import com.edwardjdp.devdaily.ui.screens.common.AppTopBar
import com.edwardjdp.devdaily.ui.screens.common.ErrorView
import com.edwardjdp.devdaily.ui.screens.common.LoadingView
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach

@ExperimentalPagingApi
@Composable
fun ArticleScreen(
    navController: NavHostController,
    viewModel: ArticleViewModel = hiltViewModel(),
) {
    val state = viewModel.uiState.collectAsState()
    val effectFlow = viewModel.effect
    viewModel.loadInitially()

    Scaffold(
        topBar = {
            AppTopBar(stringResource(id = R.string.app_name))
        },
        content = {
            DetailsContent(
                details = state.value,
                effectFlow = effectFlow,
                onRetry = viewModel::retryLoading
            )
        }
    )
}

@Composable
fun DetailsContent(
    details: ArticleContract.ArticleState,
    effectFlow: Flow<ArticleContract.ArticleEffect>,
    onRetry: () -> Unit
) {
    LaunchedEffect(effectFlow) {
        effectFlow.onEach { effect ->
            when (effect) {
                is ArticleContract.ArticleEffect.OnError -> {}
            }
        }.collect()
    }

    Column(
        modifier = Modifier
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
            .fillMaxSize()
    ) {

        when {
            details.isLoading -> {
                LoadingView(modifier = Modifier.fillMaxSize())
            }

            details.data != null -> {
                Text(text = details.data.body ?: "")
            }

            details.errorMessage != null -> {
                ErrorView(
                    message = details.errorMessage,
                    modifier = Modifier.fillMaxSize()
                ) { onRetry() }
            }
        }
    }
}