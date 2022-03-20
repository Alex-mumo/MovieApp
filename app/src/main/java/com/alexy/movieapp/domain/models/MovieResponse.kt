package com.alexy.movieapp.domain.models

import com.alexy.movieapp.data.cache.database.entity.Movie

data class MovieResponse(
    val errorMessage: String?,
    val popularMovie: List<Movie>?
)
