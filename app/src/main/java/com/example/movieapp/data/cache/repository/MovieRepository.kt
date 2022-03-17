package com.example.movieapp.data.cache.repository

import com.example.movieapp.data.data.cache.database.db.MovieDatabase
import com.example.movieapp.data.data.cache.database.entity.Movie

import com.example.movieapp.data.data.network.ApiService
import com.example.movieapp.data.utils.Resource
import com.example.movieapp.data.utils.SafeApiRequest
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class MovieRepository @Inject constructor(

    private val movieDatabase: MovieDatabase,
    private val apiClient: ApiService): SafeApiRequest() {

    suspend fun fetchMovies(name: String): Flow<Resource<List<Movie>>> = flow {


    }
}