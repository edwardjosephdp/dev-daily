package com.edwardjdp.devdaily.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.paging.ExperimentalPagingApi
import com.edwardjdp.devdaily.ui.screens.article.ArticleScreen
import com.edwardjdp.devdaily.ui.screens.catalog.CatalogScreen

@ExperimentalPagingApi
@Composable
fun SetupNavHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Catalog.route
    ) {
        composable(route = Screen.Catalog.route) {
            CatalogScreen(navController = navController)
        }
        composable(
            route = Screen.Article.route,
            arguments = listOf(
                navArgument("articleId") {
                    type = NavType.IntType
                }
            )
        ) {
            ArticleScreen(
                navController = navController,
            )
        }
    }
}

object NavKeys {

}
