package com.example.movieapp.domain.repository
import com.example.movieapp.domain.model.Movies



interface MovieRepository {

    suspend fun getMovies(id: Int): List<Movies>

    suspend fun getMoviesById(id: Int): List<Movies>
}