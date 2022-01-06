package com.example.movieapp.domain.repository

import com.example.movieapp.domain.model.Movies
import java.util.concurrent.Flow


interface MovieRepository {

    suspend fun getMovies(movieInt: Int): List<Movies>
}