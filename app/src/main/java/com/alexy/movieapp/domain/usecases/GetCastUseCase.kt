package com.alexy.movieapp.domain.usecases

import com.alexy.movieapp.domain.repositories.DetailRepository

class GetCastUseCase constructor(
    private val detailRepository: DetailRepository
    ) {
    suspend operator fun invoke(category: String) = detailRepository.getMovie(category)
}