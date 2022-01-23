package com.example.movieapp.data.repository.datasources

import androidx.lifecycle.MutableLiveData
import com.example.movieapp.data.cache.db.AppDatabase
import com.example.movieapp.data.cache.models.MoviesEntity
import com.example.movieapp.data.network.ApiService
import com.example.movieapp.data.repository.utils.Coroutines
import com.example.movieapp.domain.model.Movies
import com.example.movieapp.domain.repository.MovieRepository
import kotlinx.coroutines.CoroutineScope

class MovieRepositoryImpl constructor(
    private val apiService: ApiService,
    private val appDatabase: AppDatabase): MovieRepository {

    private val movieMovieEntity = MutableLiveData<List<MoviesEntity>>()

    init {
        movieMovieEntity.observeForever {
            Coroutines.io { saveMovies(it) }
        }

    }


    override suspend fun getMovies(id: String): List<Movies> {
        TODO("Not yet implemented")
    }

    override suspend fun getMoviesById(id: String): List<Movies> {
        TODO("Not yet implemented")
    }
    private  suspend fun saveMovies(moviesEntity: List<MoviesEntity>) = appDatabase.movieDao().saveMovies(moviesEntity)



}