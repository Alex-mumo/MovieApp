package com.example.movieapp.domain.repositories

import com.example.movieapp.domain.models.Actor
import com.example.movieapp.domain.models.MovieShow
import kotlinx.coroutines.flow.Flow

interface DetailRepository {
    suspend fun getMovie(category: String): Flow<List<MovieShow>>
    suspend fun getMovieCast(id: String): List<Actor>
}