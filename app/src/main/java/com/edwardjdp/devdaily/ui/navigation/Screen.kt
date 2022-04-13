package com.edwardjdp.devdaily.ui.navigation

sealed class Screen(val route: String) {
    object Catalog : Screen("catalog_screen")
    object Article : Screen("article_screen/{articleId}")
}
