package com.example.movieapp.domain.usecases

import com.example.movieapp.domain.repositories.DetailRepository

class GetMovieUseCase constructor(private val detailRepository: DetailRepository) {
    suspend operator fun invoke(id: String) = detailRepository.getMovie(id)
}