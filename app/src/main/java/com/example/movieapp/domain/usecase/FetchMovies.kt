package com.example.movieapp.domain.usecase

import com.example.movieapp.domain.repository.MovieRepository


class FetchMovies constructor(private val movieRepository: MovieRepository)  {
    suspend  operator fun invoke(id: String) = movieRepository.getMovies(id)
}