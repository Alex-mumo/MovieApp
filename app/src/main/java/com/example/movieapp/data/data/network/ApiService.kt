package com.example.movieapp.data.data.network

import com.example.movieapp.data.data.cache.database.entity.MovieResponse
import com.example.movieapp.data.utils.Constants.API_KEY
import retrofit2.http.GET
import retrofit2.http.Query

//k_7kgz4rka


interface ApiService {
    @GET("movie/popular")
    suspend fun fetchMovies(
        @Query("apiKey") apiKey: String = API_KEY): MovieResponse
}