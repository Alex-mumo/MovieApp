package com.alexy.movieapp.data.repository.datasources

import com.alexy.movieapp.data.cache.database.db.MovieDatabase
import com.alexy.movieapp.data.network.ApiService
import com.alexy.movieapp.data.repository.mapper.toDomain
import com.alexy.movieapp.domain.models.Actor
import com.alexy.movieapp.domain.models.MovieShow
import com.alexy.movieapp.domain.repositories.DetailRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


class MovieDetailRepositoryImpl constructor(
    private val apiService: ApiService,
    private val movieDatabase: MovieDatabase
): DetailRepository {

    override suspend fun getMovie(category: String): Flow<List<MovieShow>> {
        val databaseResponse = movieDatabase.movieDao().fetchMovies(category)
        return databaseResponse.map { it.map { movieList -> movieList.toDomain() } }
    }

    override suspend fun getMovieCast(id: String): List<Actor> {
        val movieResponse = apiService.fetchCast(id)
        return movieResponse.actors!!.map { it.toDomain() }
    }
}