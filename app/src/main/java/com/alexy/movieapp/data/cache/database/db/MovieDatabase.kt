package com.alexy.movieapp.data.data.cache.database.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.alexy.movieapp.data.data.cache.database.converters.MovieConverter
import com.alexy.movieapp.data.cache.database.dao.MovieDao
import com.alexy.movieapp.data.cache.database.entity.Movie

@Database(
    entities = [Movie::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(MovieConverter::class)
abstract class MovieDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
}