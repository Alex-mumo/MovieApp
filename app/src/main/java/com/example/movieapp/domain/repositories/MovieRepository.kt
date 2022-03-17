package com.example.movieapp.domain.repositories

import com.example.movieapp.domain.models.Movie
import kotlinx.coroutines.flow.Flow

interface MovieRepository {
    suspend fun fetchMovies(): Flow<List<Movie>>
}