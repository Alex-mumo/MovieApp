package com.alexy.movieapp.domain.usecases

import com.alexy.movieapp.domain.repositories.MovieRepository

class GetMovieUseCase constructor(private val movieRepository: MovieRepository) {
    suspend operator fun invoke() = movieRepository.fetchMovies()
}