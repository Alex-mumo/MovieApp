package com.example.movieapp.data.data.repository

import com.example.movieapp.data.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.Dispatcher
import retrofit2.HttpException

abstract class BaseRepository {

    suspend fun <T> safeApiCall(apiCall: suspend () -> T): Resource<T> {
        return withContext(Dispatchers.IO) {
            try {
                Resource.Success(apiCall.invoke())
            } catch (throwable: Throwable) {
                when(throwable){

                    is HttpException -> {
                        Resource.Error(false, throwable.code(), throwable.response()?.errorBody())

                    }
                    else -> {
                        Resource.Error(true ,null, null)

                    }
                }

            }
        }

    }
}