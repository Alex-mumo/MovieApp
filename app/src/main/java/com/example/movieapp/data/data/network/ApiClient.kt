package com.example.movieapp.data.data.network

interface ApiClient {

    suspend fun fetchMovies(): MovieResponse
}