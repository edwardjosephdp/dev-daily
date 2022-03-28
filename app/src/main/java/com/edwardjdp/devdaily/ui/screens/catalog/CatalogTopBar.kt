package com.edwardjdp.devdaily.ui.screens.catalog

import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun CatalogTopBar() {
    TopAppBar(
        title = {
            Text(
                text = "Dev Daily",
                color = Color.Blue
            )
        },
        backgroundColor = Color.White
    )
}

@Preview
@Composable
fun CatalogAppBarPreview() {
 CatalogTopBar()
}