package com.example.movieapp.data.data.network

import retrofit2.http.GET

interface ApiClient {

    @GET("movie/popular")
    suspend fun fetchMovies(): MovieResponse
}