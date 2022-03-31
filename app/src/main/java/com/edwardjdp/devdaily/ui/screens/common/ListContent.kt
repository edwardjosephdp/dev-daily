package com.edwardjdp.devdaily.ui.screens.common

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.items
import com.edwardjdp.devdaily.domain.model.ArticleUI
import com.edwardjdp.devdaily.domain.model.User
import com.edwardjdp.devdaily.ui.screens.catalog.CatalogViewModel

@ExperimentalPagingApi
@Composable
fun ListContent(
    list: LazyPagingItems<ArticleUI>,
    viewModel: CatalogViewModel
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(all = 4.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(
            items = list,
            key = { article ->
                article.id
            }
        ) { article ->
            article?.let {
                ArticleItem(
                    model = it,
                    onSelectArticle = viewModel::viewArticle
                )
            }
        }

        list.apply {
            when {
                loadState.refresh is LoadState.Loading -> {
                    item { LoadingView(modifier = Modifier.fillParentMaxSize()) }
                }
                loadState.append is LoadState.Loading -> {
                    item { LoadingItem() }
                }
                loadState.refresh is LoadState.Error -> {
                    val e = list.loadState.refresh as LoadState.Error
                    item {
                        ErrorView(
                            message = e.error.localizedMessage!!,
                            modifier = Modifier.fillParentMaxSize(),
                            onClickRetry = { retry() }
                        )
                    }
                }
                loadState.append is LoadState.Error -> {
                    val e = list.loadState.append as LoadState.Error
                    item {
                        ErrorView(
                            message = e.error.localizedMessage!!,
                            onClickRetry = { retry() }
                        )
                    }
                }
            }
        }
    }
}

@ExperimentalPagingApi
@Composable
fun ArticleItem(
    model: ArticleUI,
    onSelectArticle: (Int) -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth()
            .clickable {
                onSelectArticle(model.id)
            },
        shape = RoundedCornerShape(10.dp),
        elevation = 4.dp
    ) {
        ConstraintLayout(modifier = Modifier
            .fillMaxWidth()
            .padding(all = 8.dp)
        ) {
            val (title, author, publishedDate) = createRefs()
            Text(
                text = model.title ?: "N/A",
                modifier = Modifier
                    .constrainAs(ref = title) {
                        top.linkTo(anchor = parent.top, margin = 8.dp)
                        start.linkTo(anchor = parent.start, margin = 8.dp)
                        end.linkTo(anchor = parent.end, margin = 8.dp)
                    }
                    .fillMaxWidth()
                    .padding(4.dp),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = model.user.userName ?: "N/A",
                modifier = Modifier
                    .constrainAs(author) {
                        top.linkTo(anchor = title.bottom, margin = 12.dp)
                        start.linkTo(anchor = parent.start)
                    }
                    .wrapContentSize()
                    .padding(4.dp),
            )

            Text(
                text = model.readablePublishDate ?: "N/A",
                modifier = Modifier
                    .constrainAs(publishedDate) {
                        top.linkTo(anchor = title.bottom, margin = 12.dp)
                        end.linkTo(anchor = parent.end)
                    }
                    .wrapContentSize()
                    .padding(4.dp),
            )
        }
    }
}

@ExperimentalPagingApi
@Preview
@Composable
fun ArticleItemPreview() {
    ArticleItem(model = ArticleUI(
        id = 11230,
        type = "article",
        title = "Long titleeee",
        description = "description",
        coverImage = "cover",
        path = "/path",
        headerImageUrl = "",
        tags = listOf(),
        user = User(
            name = "john doe",
            githubUserName = "jdoeee",
            userName = "jdoe11230",
            image90Url = "",
            image640Url = ""
        ),
        positiveReactionsCount = 1,
        publicReactionsCount = 1,
        readingTimeMinutes = 15,
        body = null,
        readablePublishDate = "Mar 12, 2022",
        publishedTimestamp = ""
    ),
        onSelectArticle = {}
    )
}

@Composable
fun LoadingItem() {
    CircularProgressIndicator(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
            .wrapContentWidth(Alignment.CenterHorizontally)
    )
}
