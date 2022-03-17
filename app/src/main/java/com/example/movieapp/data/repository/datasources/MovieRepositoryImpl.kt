package com.example.movieapp.data.repository.datasources

import androidx.lifecycle.MutableLiveData
import com.example.movieapp.data.cache.database.entity.Movie
import com.example.movieapp.data.data.cache.database.db.MovieDatabase
import com.example.movieapp.data.data.network.ApiService
import com.example.movieapp.data.data.repository.utils.Coroutines
import com.example.movieapp.domain.repositories.MovieRepository
import kotlinx.coroutines.flow.Flow

class MovieRepositoryImpl constructor(
    private val movieDatabase: MovieDatabase,
    private val apiService: ApiService): MovieRepository{

    private val popularMovies = MutableLiveData<List<Movie>>()

    init {
        popularMovies.observeForever {
            Coroutines.io { saveMovies(it) }
        }
    }

    private suspend fun saveMovies(movie: List<Movie>) {
        movieDatabase.movieDao().saveMovies(movie)

    }

    override suspend fun fetchMovies(): Flow<List<Movie>> {

    }


}