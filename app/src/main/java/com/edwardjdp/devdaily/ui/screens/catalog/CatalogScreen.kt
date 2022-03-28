package com.edwardjdp.devdaily.ui.screens.catalog

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.paging.ExperimentalPagingApi
import androidx.paging.compose.collectAsLazyPagingItems
import com.edwardjdp.devdaily.ui.screens.common.ListContent

@ExperimentalPagingApi
@Composable
fun CatalogScreen(
    navController: NavHostController,
    viewModel: CatalogViewModel = hiltViewModel()
) {
    Scaffold(
        topBar = {
            CatalogTopBar()
        },
        content = {
            ListContent(viewModel.pagingData.collectAsLazyPagingItems())
        }
    )
}
