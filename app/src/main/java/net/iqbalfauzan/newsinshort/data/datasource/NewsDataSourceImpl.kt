package net.iqbalfauzan.newsinshort.data.datasource

import net.iqbalfauzan.newsinshort.data.api.ApiService
import net.iqbalfauzan.newsinshort.data.entity.NewsResponse
import retrofit2.Response
import javax.inject.Inject

class NewsDataSourceImpl @Inject constructor(
    private val apiService: ApiService
) : NewsDataSource {
    override suspend fun getNewsHeadline(country: String): Response<NewsResponse> {
        return apiService.getNewsHeadline(country)
    }
}