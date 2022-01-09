package com.example.movieapp.data.cache.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movie_table")
data class MoviesEntity (
    @PrimaryKey(autoGenerate = true)
    val id: Int,

    val name: String?,

    val image: String?,

    val title: String?,

    val category: String?
)