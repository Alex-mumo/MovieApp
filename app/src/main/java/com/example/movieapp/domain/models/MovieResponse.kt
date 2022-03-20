package com.example.movieapp.domain.models

import com.example.movieapp.data.cache.database.entity.Movie

data class MovieResponse(
    val errorMessage: String?,
    val popularMovie: List<Movie>?
)
