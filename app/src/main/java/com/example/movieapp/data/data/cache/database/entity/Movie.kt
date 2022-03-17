package com.example.movieapp.data.data.cache.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movie_table")
data class Movie(
    @PrimaryKey(autoGenerate = true)
    val id: String,
    val imDbRating: String?,
    val imDbRatingCount: String?,
    val image: String?,
    val title: String?,
    val category: String?
)