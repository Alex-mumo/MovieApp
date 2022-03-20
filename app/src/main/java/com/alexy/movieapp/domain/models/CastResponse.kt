package com.example.movieapp.domain.models

data class CastResponse(
    val actors: List<Actor>?,
    val errorMessage: String?,
    val imDbId: String?,
    val fullTitle: String?,
    val title: String?,
    val year: String?,
    val type: String?
)