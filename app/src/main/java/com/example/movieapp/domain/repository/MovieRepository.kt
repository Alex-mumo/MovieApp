package com.example.movieapp.domain.repository

import com.example.movieapp.domain.model.Movies


interface MovieRepository {

    suspend fun getMovies(movieInt: Int): List<Movies>
}