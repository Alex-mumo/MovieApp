package com.example.movieapp.data.network

import com.example.movieapp.data.model.Movies
import retrofit2.Response

class ApiServiceHelperImpl(private val apiService: ApiService) : ApiServiceHelper {
    override suspend fun getMovies() : Response<List<Movies>> = apiService.getMovies()
}