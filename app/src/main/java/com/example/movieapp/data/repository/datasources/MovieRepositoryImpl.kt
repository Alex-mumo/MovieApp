package com.example.movieapp.data.repository.datasources

import androidx.lifecycle.MutableLiveData
import com.example.movieapp.data.cache.database.entity.Movie
import com.example.movieapp.data.data.cache.database.db.MovieDatabase
import com.example.movieapp.data.data.network.ApiService
import com.example.movieapp.data.data.repository.utils.Coroutines
import com.example.movieapp.data.repository.mapper.toDomain
import com.example.movieapp.data.repository.mapper.toEntity
import com.example.movieapp.domain.models.MovieShow
import com.example.movieapp.domain.repositories.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class MovieRepositoryImpl constructor(
    private val movieDatabase: MovieDatabase,
    private val apiService: ApiService): MovieRepository{

    private val _popularMovies = MutableLiveData<List<Movie>>()

    init {
        _popularMovies.observeForever {
            Coroutines.io { saveMovies(it) }
        }
    }

    private suspend fun saveMovies(movie: List<Movie>) {
        movieDatabase.movieDao().saveMovies(movie)
    }

    override suspend fun fetchMovies(): Flow<List<MovieShow>> {
        val isCacheAvailable = movieDatabase.movieDao().isCacheAvailable(category = "MostPopularTVs") > 0
        return if (isCacheAvailable) {
            val cacheResponse = movieDatabase.movieDao().fetchMovies(category = "MostPopularTVs")
            cacheResponse.map { it.map { movieList -> movieList.toDomain() } }
        } else {
            val networkResponse = apiService.fetchMovies()
            _popularMovies.value = networkResponse.movies?.map { it.toEntity(category = "MostPopularTVs") }
            val cacheResponse = movieDatabase.movieDao().fetchMovies(category = "MostPopularTVs")
            cacheResponse.map { it.map { movieList -> movieList.toDomain() } }
        }
    }
}


//https://imdb-api.com/en/API/MostPopularTVs/k_7kgz4rka