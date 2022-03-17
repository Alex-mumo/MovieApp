package com.example.movieapp.data.cache.di

import android.content.Context
import androidx.room.Room
import com.example.movieapp.data.data.cache.database.dao.MovieDao
import com.example.movieapp.data.data.cache.database.db.MovieDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object CacheModule {

    @Provides
    @Singleton
    fun providesDatabase(@ApplicationContext context: Context): MovieDatabase {
        return Room.databaseBuilder(context, MovieDatabase::class.java, "movie_db")
            .fallbackToDestructiveMigration()
            .build()
    }
    @Provides
    @Singleton
    fun providesData(movieDatabase: MovieDatabase): MovieDao {
        return movieDatabase.movieDao()
    }
}