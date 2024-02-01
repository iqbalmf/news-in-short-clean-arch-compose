package net.iqbalfauzan.newsinshort.ui.screens

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import net.iqbalfauzan.newsinshort.data.entity.NewsResponse
import net.iqbalfauzan.newsinshort.ui.components.EmptyStateComponent
import net.iqbalfauzan.newsinshort.ui.components.Loader
import net.iqbalfauzan.newsinshort.ui.components.NewsRowComponent
import net.iqbalfauzan.newsinshort.ui.navigation.AppNavigationGraph
import net.iqbalfauzan.newsinshort.ui.viewmodel.NewsViewModel
import net.iqbalfauzan.utilities.ResourceState

@Composable
fun HomeScreen(
    newsViewModel: NewsViewModel = hiltViewModel()
) {
    val newsRes by newsViewModel.news.collectAsState()

    when (newsRes) {
        is ResourceState.Loading -> {
            Loader()
        }

        is ResourceState.Success -> {
            val response = (newsRes as ResourceState.Success).data
            if (response.articles.isNotEmpty()) {
                VerticalPagerWithIndicator(response = response)
            } else {
                EmptyStateComponent()
            }
        }

        is ResourceState.Error -> {
            val error = newsRes as ResourceState.Error
            Log.e(HomeScreen().javaClass.simpleName.toString(), error.error)
            EmptyStateComponent()
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun VerticalPagerWithIndicator(response: NewsResponse) {
    val pagerState = rememberPagerState {
        response.articles.size
    }
    VerticalPager(
        state = pagerState,
        modifier = Modifier.fillMaxHeight(),
        pageSize = PageSize.Fill,
        pageSpacing = 8.dp
    ) { page: Int ->
        NewsRowComponent(page, response.articles[page])
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    AppNavigationGraph()
}