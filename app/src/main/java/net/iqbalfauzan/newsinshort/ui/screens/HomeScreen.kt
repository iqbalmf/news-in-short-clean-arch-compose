package net.iqbalfauzan.newsinshort.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import net.iqbalfauzan.newsinshort.ui.components.Loader
import net.iqbalfauzan.newsinshort.ui.navigation.AppNavigationGraph
import net.iqbalfauzan.newsinshort.ui.viewmodel.NewsViewModel
import net.iqbalfauzan.utilities.ResourceState

@Composable
fun HomeScreen(
    newsViewModel: NewsViewModel = hiltViewModel()
){
    val newsRes by newsViewModel.news.collectAsState()

    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        when(newsRes){
            is ResourceState.Loading -> {
                Loader()
            }
            is ResourceState.Success -> {}
            is ResourceState.Error -> {}
        }
    }
}
@Preview
@Composable
fun HomeScreenPreview(){
    AppNavigationGraph()
}