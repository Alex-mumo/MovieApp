package com.alexy.movieapp.domain.usecases

import com.alexy.movieapp.domain.repositories.DetailRepository
import javax.inject.Inject

class GetCastUseCase @Inject constructor(
    private val detailRepository: DetailRepository
    ) {
    suspend operator fun invoke(category: String) = detailRepository.getMovie(category)
}