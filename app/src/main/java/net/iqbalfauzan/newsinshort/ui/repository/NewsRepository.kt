package net.iqbalfauzan.newsinshort.ui.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import net.iqbalfauzan.newsinshort.data.datasource.NewsDataSource
import net.iqbalfauzan.newsinshort.data.entity.NewsResponse
import net.iqbalfauzan.utilities.ResourceState
import javax.inject.Inject

class NewsRepository @Inject constructor(
    private val newsDataSource: NewsDataSource
) {

    suspend fun getNewsHeadline(country: String): Flow<ResourceState<NewsResponse>> {
        return flow {
            emit(ResourceState.Loading())
            val response = newsDataSource.getNewsHeadline(country)
            if (response.isSuccessful && response.body() != null) {
                emit(ResourceState.Success(response.body()!!))
            } else {
                emit(ResourceState.Error("Error Fetching news data"))
            }
        }.catch { e ->
            emit(ResourceState.Error(e.localizedMessage ?: "Some Error in Flow"))
        }
    }
}