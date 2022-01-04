package com.example.movieapp.data.network

import com.example.movieapp.data.model.Movies
import retrofit2.Response

interface ApiServiceHelper {
    suspend fun getMovies() : Response<List<Movies>>
}