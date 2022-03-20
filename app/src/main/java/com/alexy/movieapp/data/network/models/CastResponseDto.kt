package com.example.movieapp.data.data.network.models

data class CastResponseDto(
    val actors: List<CastDto>?,
    val errorMessage: String?,
    val imDbId: String?,
    val fullTitle: String?,
    val title: String?,
    val year: String?,
    val type: String?
)
