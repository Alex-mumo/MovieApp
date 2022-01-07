package com.example.movieapp.data.cache.converters

import androidx.room.TypeConverters
import com.example.movieapp.data.cache.models.MoviesEntity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object MovieEntityConverter {
    private val gson = Gson()

    @TypeConverters
    fun fromMovies(movies: List<MoviesEntity>) : String? {
        if (movies.isNullOrEmpty()) return null
        val type = object : TypeToken<List<MoviesEntity>?>() {}.type
        return gson.toJson(movies, type)
    }
    fun toMovies(movies: String?): List<MoviesEntity>? {
        if (movies.isNullOrEmpty()) return null
        val type = object : TypeToken<List<MoviesEntity>?>() {}.type
        return gson.fromJson(movies, type)
    }
}