package com.example.movieapp.data.network

import com.example.movieapp.domain.model.Movies
import retrofit2.Response

interface ApiService {

    companion object {
        // api url
        val BASE_URL = "https://api.themoviedb.org/3/"
    }

    suspend fun getMovies() : Response<List<Movies>>

}