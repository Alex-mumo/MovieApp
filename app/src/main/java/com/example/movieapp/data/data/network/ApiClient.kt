package com.example.movieapp.data.data.network

import com.example.movieapp.data.utils.Constants.API_KEY
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiClient {
    @GET("movie/popular")
    suspend fun fetchMovies(
        @Query("apiKey"
        ) apiKey: String = API_KEY): MovieResponse
}