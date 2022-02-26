package com.example.movieapp.data.utils

import okhttp3.ResponseBody

sealed class Resource<out T> {
    //val data: T? = null,
    //val message: String? = null){

    data class Success<out T>(
        val value: T
        ): Resource<T>()

    data class Error(
        val isNetworkError: Boolean,
        val errorCode: Int?,
        val errorBody: ResponseBody?
    ): Resource<Nothing>()

    object Loading: Resource<Nothing>()

}