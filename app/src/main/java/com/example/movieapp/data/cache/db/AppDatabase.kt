package com.example.movieapp.data.cache.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.movieapp.data.cache.dao.MovieDao
import com.example.movieapp.domain.model.Movies

@Database(entities = [Movies::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun movieDao(): MovieDao
}