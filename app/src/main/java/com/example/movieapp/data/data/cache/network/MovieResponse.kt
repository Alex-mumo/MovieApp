package com.example.movieapp.data.data.cache.network

import com.example.movieapp.data.data.cache.database.entity.Movie

data class MovieResponse(
    val results: List<Movie>
)
