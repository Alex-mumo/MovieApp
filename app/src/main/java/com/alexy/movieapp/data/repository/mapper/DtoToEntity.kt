package com.alexy.movieapp.data.repository.mapper

import com.alexy.movieapp.data.cache.database.entity.Movie
import com.alexy.movieapp.data.network.models.MovieDto

internal fun MovieDto.toEntity(category: String?): Movie {
    return Movie(
        id = this.id,
        imDbRating = this.imDbRating,
        imDbRatingCount = this.imDbRatingCount,
        image = this.image,
        title = this.title,
        category = category
    )
}