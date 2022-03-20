package com.alexy.movieapp.data.data.network

import com.alexy.movieapp.data.data.network.models.CastResponseDto
import com.alexy.movieapp.data.data.network.models.MovieResponseDto
import com.alexy.movieapp.presentation.utils.Constants
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("MostPopularMovies/{apiKey}")
    suspend fun fetchMovies(
        @Path("apiKey")
        apiKey: String = Constants.API_KEY
    ): MovieResponseDto

    @GET("FullCast/{apiKey}/{id}")
    suspend fun fetchCast(
        @Path("apiKey")
        apiKey: String = Constants.API_KEY
    ): CastResponseDto
}