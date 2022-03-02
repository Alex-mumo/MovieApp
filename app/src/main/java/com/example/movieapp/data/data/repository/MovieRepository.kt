package com.example.movieapp.data.data.repository

import com.example.movieapp.data.data.database.dao.MovieDao
import com.example.movieapp.data.data.database.entity.Movie
import com.example.movieapp.data.data.network.ApiClient
import com.example.movieapp.data.utils.SafeApiRequest
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MovieRepository @Inject constructor(
    private val movieDao: MovieDao,
    private val apiClient: ApiClient): SafeApiRequest() {

    suspend fun saveMovie(movie: List<Movie>){
        movieDao.saveMovies(movie)
    }
    fun fetchMoviesDb(): Flow<List<Movie>>{
        return movieDao.getMovies()
    }

    suspend fun getMovies() = safeApiCall {
        apiClient.fetchMovies()
    }
}