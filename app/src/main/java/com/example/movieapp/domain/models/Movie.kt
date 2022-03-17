package com.example.movieapp.domain.models

data class Movie(
    val id: String,
    val imDbRating: String?,
    val imDbRatingCount: String?,
    val image: String?,
    val title: String?,
)
