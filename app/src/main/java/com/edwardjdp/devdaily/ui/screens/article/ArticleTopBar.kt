package com.edwardjdp.devdaily.ui.screens.article

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun ArticleTopBar(title: String, onBack: () -> Unit = {}) {
    TopAppBar(
        title = {
            Text(
                text = title,
                color = Color.Blue
            )
        },
        backgroundColor = Color.White,
        navigationIcon = {
            IconButton(onClick = onBack) {
                Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "Back")
            }
        }
    )
}
