package com.edwardjdp.devdaily.ui.screens.catalog

import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun CatalogTopBar(title: String) {
    TopAppBar(
        title = {
            Text(
                text = title,
                color = Color.Blue
            )
        },
        backgroundColor = Color.White,
    )
}