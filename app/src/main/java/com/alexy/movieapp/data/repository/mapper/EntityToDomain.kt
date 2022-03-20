package com.alexy.movieapp.data.repository.mapper

import com.alexy.movieapp.data.cache.database.entity.Movie
import com.alexy.movieapp.domain.models.MovieShow


internal fun Movie.toDomain(): MovieShow {
    return MovieShow(
        id = this.id,
        imDbRating = this.imDbRating,
        imDbRatingCount = this.imDbRatingCount,
        image = this.image,
        title = this.image
    )
}