package com.example.movieapp.data.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.movieapp.data.data.dao.MovieDao
import com.example.movieapp.data.data.entity.Movie

@Database(entities = [Movie::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun movieDao(): MovieDao
}