package com.example.movieapp.domain.models

data class MovieResponse(
    val errorMessage: String?,
    val popularMovie: List<Movie>?
)
