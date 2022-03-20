package com.alexy.movieapp.domain.repositories

import com.alexy.movieapp.domain.models.MovieShow
import kotlinx.coroutines.flow.Flow

interface MovieRepository {
    suspend fun fetchMovies(): Flow<List<MovieShow>>
}