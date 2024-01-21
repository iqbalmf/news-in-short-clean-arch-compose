package net.iqbalfauzan.newsinshort.data.datasource

import net.iqbalfauzan.newsinshort.data.entity.NewsResponse
import retrofit2.Response

interface NewsDataSource {
    suspend fun getNewsHeadline(country: String): Response<NewsResponse>
}