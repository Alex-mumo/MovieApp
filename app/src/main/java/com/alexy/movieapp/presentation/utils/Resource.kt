package com.alexy.movieapp.presentation.utils

import com.alexy.movieapp.domain.models.MovieShow

sealed class Resource {
    object Loading : Resource()
    data class Success(val data: List<MovieShow>): Resource()
    data class Error(val error: String): Resource()
}