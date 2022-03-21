package com.alexy.movieapp.data.network.models

import com.google.gson.annotations.SerializedName

data class MovieResponseDto(
    @SerializedName("errorMessage")
    val errorMessage: String?,
    @SerializedName("movies")
    val movies: List<MovieDto>?
)
