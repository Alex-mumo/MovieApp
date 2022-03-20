package com.example.movieapp.data.data.network.models

data class MovieResponseDto(
    val errorMessage: String?,
    val movies: List<MovieDto>?
)
