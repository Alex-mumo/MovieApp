package com.alexy.movieapp.domain.usecases

import com.alexy.movieapp.domain.repositories.MovieRepository
import javax.inject.Inject

class GetMovieUseCase @Inject constructor(private val movieRepository: MovieRepository) {
    suspend operator fun invoke() = movieRepository.fetchMovies()
}