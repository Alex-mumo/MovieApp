package com.alexy.movieapp.data.data.network.models

data class MovieDto (
    val id: String,
    val imDbRating: String?,
    val imDbRatingCount: String?,
    val image: String?,
    val title: String?,
    val category: String?
)