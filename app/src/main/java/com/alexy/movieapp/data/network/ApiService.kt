package com.alexy.movieapp.data.network

import com.alexy.movieapp.data.network.models.CastResponseDto
import com.alexy.movieapp.data.network.models.MovieResponseDto
import com.alexy.movieapp.presentation.utils.Constants
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("MostPopularTVs/{apiKey}")
    suspend fun fetchMovies(@Path("apiKey") apiKey: String = Constants.API_KEY): MovieResponseDto

    @GET("FullCast/{apiKey}/{id}")
    suspend fun fetchCast(@Path("apiKey") apiKey: String = Constants.API_KEY): CastResponseDto
}