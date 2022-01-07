package com.example.movieapp.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movies_table")
data class Movies(
    @PrimaryKey(autoGenerate = true)
    val id : String,

    val image: String,

    val title: String,

    val category: String
)
