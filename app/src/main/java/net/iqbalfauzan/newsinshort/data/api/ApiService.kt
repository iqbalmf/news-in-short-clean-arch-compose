package net.iqbalfauzan.newsinshort.data.api

import net.iqbalfauzan.newsinshort.data.entity.NewsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("v2/top-headlines")
    suspend fun getNewsHeadline(
        @Query("country") country: String,
        @Query("apiKey") apiKey: String = "150909ebccbf440c82689ee3a0e7f722"
    ): Response<NewsResponse>
}