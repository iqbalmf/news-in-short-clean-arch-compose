package net.iqbalfauzan.newsinshort.ui.screens

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import net.iqbalfauzan.newsinshort.ui.components.EmptyStateComponent
import net.iqbalfauzan.newsinshort.ui.components.Loader
import net.iqbalfauzan.newsinshort.ui.components.NewsList
import net.iqbalfauzan.newsinshort.ui.components.NewsRowComponent
import net.iqbalfauzan.newsinshort.ui.navigation.AppNavigationGraph
import net.iqbalfauzan.newsinshort.ui.viewmodel.NewsViewModel
import net.iqbalfauzan.utilities.ResourceState

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
    newsViewModel: NewsViewModel = hiltViewModel()
) {
    val newsRes by newsViewModel.news.collectAsState()

    val pagerState = rememberPagerState(
        initialPage = 0,
        initialPageOffsetFraction = 0f
    ) {
        100
    }
    VerticalPager(
        state = pagerState,
        modifier = Modifier.fillMaxSize(),
        pageSize = PageSize.Fill,
        pageSpacing = 8.dp
    ) { page: Int ->
        when (newsRes) {
            is ResourceState.Loading -> {
                Loader()
            }

            is ResourceState.Success -> {
                val response = (newsRes as ResourceState.Success).data
                if (response.articles.isNotEmpty()) {
                    NewsRowComponent(page, response.articles.get(page))
                } else {
                    EmptyStateComponent()
                }
            }

            is ResourceState.Error -> {
                val error = newsRes as ResourceState.Error
                Log.e(HomeScreen().javaClass.simpleName.toString(), error.error)
            }
        }
    }

}

@Preview
@Composable
fun HomeScreenPreview() {
    AppNavigationGraph()
}