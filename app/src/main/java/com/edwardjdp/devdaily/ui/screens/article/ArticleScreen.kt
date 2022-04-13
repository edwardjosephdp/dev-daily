package com.edwardjdp.devdaily.ui.screens.article

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.paging.ExperimentalPagingApi
import com.edwardjdp.devdaily.R
import com.edwardjdp.devdaily.ui.screens.common.ErrorView
import com.edwardjdp.devdaily.ui.screens.common.LoadingView
import com.halilibo.richtext.markdown.Markdown
import com.halilibo.richtext.ui.RichText
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
            ArticleTopBar(
                title = stringResource(id = R.string.app_name),
                onBack = navController::popBackStack
            )
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
            .verticalScroll(rememberScrollState())
            .fillMaxSize()
    ) {

        when {
            details.isLoading -> {
                LoadingView(modifier = Modifier.fillMaxSize())
            }

            details.data != null -> {
                Box(
                    modifier = Modifier
                        .padding(start = 16.dp, top = 24.dp, end = 16.dp, bottom = 8.dp)
                        .fillMaxWidth()
                ) {
                    Text(
                        text = details.data.title ?: "",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                RichText(modifier = Modifier.padding(start = 16.dp, top = 8.dp, end = 16.dp, bottom = 32.dp)) {
                    Markdown(content = """${details.data.body.orEmpty()}""".trimIndent())
                }
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
