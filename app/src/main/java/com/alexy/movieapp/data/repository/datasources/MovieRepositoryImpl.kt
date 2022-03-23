package com.alexy.movieapp.data.repository.datasources

import androidx.lifecycle.MutableLiveData
import com.alexy.movieapp.data.cache.database.entity.Movie
import com.alexy.movieapp.data.cache.database.db.MovieDatabase
import com.alexy.movieapp.data.network.ApiService
import com.alexy.movieapp.data.repository.mapper.toDomain
import com.alexy.movieapp.data.repository.mapper.toEntity
import com.alexy.movieapp.domain.models.MovieShow
import com.alexy.movieapp.domain.repositories.MovieRepository
import com.alexy.movieapp.presentation.utils.Constants.POPULAR_MOVIE
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class MovieRepositoryImpl  constructor(
    private val movieDatabase: MovieDatabase,
    private val apiService: ApiService
): MovieRepository {
    private val _popularMovies = MutableLiveData<List<Movie>>()

    /*init {
        _popularMovies.observeForever {
            Coroutines.io { saveMovies(it) }
        }
    }

     */
    override suspend fun fetchMovies(): Flow<List<MovieShow>> {
        val isCacheAvailable = movieDatabase.movieDao().isCacheAvailable(category = POPULAR_MOVIE) > 0
        return if (isCacheAvailable) {
            val cacheResponse = movieDatabase.movieDao().fetchMovies(category = POPULAR_MOVIE)
            cacheResponse.map { it.map { movieList -> movieList.toDomain() } }
        } else {
            val networkResponse = apiService.fetchMovies()
            _popularMovies.value = networkResponse.movies?.map { it.toEntity(category = POPULAR_MOVIE) }
            val cacheResponse = movieDatabase.movieDao().fetchMovies(category = POPULAR_MOVIE)
            cacheResponse.map { it.map { movieList -> movieList.toDomain() } }
        }
    }
    /*
   private suspend fun saveMovies(movie: List<Movie>) {
        movieDatabase.movieDao().saveMovies(movie)
    }

     */
}