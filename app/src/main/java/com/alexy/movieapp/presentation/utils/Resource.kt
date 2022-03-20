package com.example.movieapp.presentation.utils

import com.example.movieapp.domain.models.MovieShow

sealed class Resource {
    object Loading : Resource()
    data class Success(val data: List<MovieShow>): Resource()
    data class Error(val error: String): Resource()
}