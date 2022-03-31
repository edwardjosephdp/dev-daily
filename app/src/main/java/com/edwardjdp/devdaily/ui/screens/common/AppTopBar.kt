package com.edwardjdp.devdaily.ui.screens.common

import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.edwardjdp.devdaily.R

@Composable
fun AppTopBar(title: String) {
    TopAppBar(
        title = {
            Text(
                text = title,
                color = Color.Blue
            )
        },
        backgroundColor = Color.White
    )
}

@Preview
@Composable
fun CatalogAppBarPreview() {
 AppTopBar(stringResource(id = R.string.app_name))
}