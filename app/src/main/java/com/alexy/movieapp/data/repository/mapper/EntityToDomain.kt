package com.example.movieapp.data.repository.mapper

import com.example.movieapp.data.cache.database.entity.Movie
import com.example.movieapp.domain.models.MovieShow


internal fun Movie.toDomain(): MovieShow {
    return MovieShow(
        id = this.id,
        imDbRating = this.imDbRating,
        imDbRatingCount = this.imDbRatingCount,
        image = this.image,
        title = this.image
    )
}