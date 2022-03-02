package com.example.movieapp.data.di

import android.content.Context
import androidx.room.Room
import com.example.movieapp.data.data.database.dao.MovieDao
import com.example.movieapp.data.data.database.db.MovieDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun providesDatabase(@ApplicationContext context: Context): MovieDatabase =
        Room.databaseBuilder(context, MovieDatabase::class.java, "movie_db")
            .fallbackToDestructiveMigration()
            .build()

    @Provides
    @Singleton
    fun providesDao(movieDatabase: MovieDatabase): MovieDao =
        movieDatabase.movieDao()
}