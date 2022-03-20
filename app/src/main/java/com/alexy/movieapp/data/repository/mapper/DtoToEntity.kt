package com.example.movieapp.data.repository.mapper

import com.example.movieapp.data.cache.database.entity.Movie
import com.example.movieapp.data.data.network.models.MovieDto

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