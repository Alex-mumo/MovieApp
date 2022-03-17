package com.example.movieapp.domain.usecases

import com.example.movieapp.domain.repositories.DetailRepository

class GetCastUseCase constructor(private val detailRepository: DetailRepository) {
    suspend operator fun invoke(category: String) = detailRepository.getMovie(category)

}