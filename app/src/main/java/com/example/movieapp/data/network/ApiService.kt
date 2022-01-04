package com.example.movieapp.data.network

import com.example.movieapp.data.model.Movies
import retrofit2.Response

interface ApiService {

    suspend fun getMovies() : Response<List<Movies>>

}