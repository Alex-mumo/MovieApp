package com.example.movieapp.domain.repository
import com.example.movieapp.domain.model.Movies
import java.util.concurrent.Flow


interface MovieRepository {

    suspend fun getMovies(id: String): List<Movies>

    suspend fun getMoviesById(id: String): List<Movies>
    //abstract fun saveMovies(it: List<MoviesEntity>?)
}