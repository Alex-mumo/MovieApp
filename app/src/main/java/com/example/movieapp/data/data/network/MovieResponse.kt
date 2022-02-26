package com.example.movieapp.data.data.network

import com.example.movieapp.data.data.database.entity.Movie

data class MovieResponse(
    val results: List<Movie>
)
