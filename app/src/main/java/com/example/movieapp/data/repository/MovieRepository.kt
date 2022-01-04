package com.example.movieapp.data.repository

import com.example.movieapp.data.network.ApiServiceHelper

class MovieRepository (private val apiServiceHelper: ApiServiceHelper) {
    suspend fun getMovies() = apiServiceHelper.getMovies()
}