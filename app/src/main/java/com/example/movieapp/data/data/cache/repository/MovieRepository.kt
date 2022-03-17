package com.example.movieapp.data.data.cache.repository

import com.example.movieapp.data.data.cache.database.db.MovieDatabase
import com.example.movieapp.data.data.cache.database.entity.Movie
import com.example.movieapp.data.data.cache.network.ApiClient
import com.example.movieapp.data.utils.Resource
import com.example.movieapp.data.utils.SafeApiRequest
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class MovieRepository @Inject constructor(
    //private val movieDao: MovieDao,
    private val movieDatabase: MovieDatabase,
    private val apiClient: ApiClient): SafeApiRequest() {

    suspend fun fetchMovies(name: String): Flow<Resource<List<Movie>>> = flow {
        emit(Resource.Loading())

        val movieDetail = movieDatabase.movieDao().getMovies(name)
        emit(Resource.Loading(data = movieDetail))

        try {
            val data = apiClient.fetchMovies(name)
            movieDatabase.movieDao().saveMovies(data.results)

        }catch (e: HttpException) {
            emit(
                Resource.Error(message = "Oops something went wrong", data = movieDetail)
            )

        }catch (e: IOException) {
            emit(
                Resource.Error("Internet Error", data = movieDetail)
            )
        }
        //val newMovie = movieDatabase.movieDao().saveMovies()
        //emit(Resource.Success())

    }
}