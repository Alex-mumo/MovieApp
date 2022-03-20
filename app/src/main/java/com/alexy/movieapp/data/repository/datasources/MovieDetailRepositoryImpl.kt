package com.example.movieapp.data.repository.datasources

import com.example.movieapp.data.data.cache.database.db.MovieDatabase
import com.example.movieapp.data.data.network.ApiService
import com.example.movieapp.data.repository.mapper.toDomain
import com.example.movieapp.domain.models.Actor
import com.example.movieapp.domain.models.MovieShow
import com.example.movieapp.domain.repositories.DetailRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class MovieDetailRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val movieDatabase: MovieDatabase): DetailRepository {

    override suspend fun getMovie(category: String): Flow<List<MovieShow>> {
        val databaseResponse = movieDatabase.movieDao().fetchMovies(category)
        return databaseResponse.map { it.map { movieList -> movieList.toDomain() } }
    }

    override suspend fun getMovieCast(id: String): List<Actor> {
        val movieResponse = apiService.fetchCast(id)
        return movieResponse.actors!!.map { it.toDomain() }
    }
}