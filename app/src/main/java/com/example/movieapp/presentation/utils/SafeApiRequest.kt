package com.example.movieapp.data.utils

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException

abstract class SafeApiRequest {

    suspend fun <T> safeApiCall(apiCall: suspend () -> T): Resource<T> {

        return withContext(Dispatchers.IO) {
            try {
                Resource.Success(apiCall.invoke())
            }catch (throwable: Throwable){
                when(throwable){
                    is HttpException -> {
                        Resource.Error(false, throwable.code(), throwable.response()?.errorBody())
                    }
                    else -> {
                        Resource.Error(true, null, null)
                    }
                }
            }
        }
    }
}

/*
suspend fun <T : Any> safeApiCall(call: suspend () -> MovieResponse): T {
    val response = call.invoke()
    if (response.isSuccessful) {
        return response.body()!!
    } else {
        val responseErr = response.errorBody()?.string()
        val message = StringBuilder()
        responseErr?.let {
            try {
                message.append(JSONObject(it).getString("message"))
            } catch (e: JSONException) {
            }
        }
        throw ApiException(message.toString())
    }
}
*/