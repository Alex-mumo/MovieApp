package com.example.movieapp.domain.usecase

import com.example.movieapp.domain.model.Movies
import com.example.movieapp.domain.repository.MovieRepository
import kotlinx.coroutines.flow.flowOf

class FetchMovies(private val repository: MovieRepository)  {
    operator fun invoke() {
        TODO("Not yet implemented")
    }
    // suspend operator fun invoke(movieId : Int): List<Movies> {
     //   return flowOf(repository.getMovies())
   // }
}