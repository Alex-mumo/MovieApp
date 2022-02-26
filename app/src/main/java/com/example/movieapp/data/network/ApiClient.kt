package com.example.movieapp.data.network

interface ApiClient {

    suspend fun fetchMovies(): MovieResponse
}