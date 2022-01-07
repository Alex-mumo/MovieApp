package com.example.movieapp.data.repository

class MovieRepository (private val apiServiceHelper: ApiServiceHelper) {
    suspend fun getMovies() = apiServiceHelper.getMovies()
}