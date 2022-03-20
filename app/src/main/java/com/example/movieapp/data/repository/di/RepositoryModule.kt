package com.example.movieapp.data.repository.di

import android.content.Context
import com.example.movieapp.data.data.cache.database.db.MovieDatabase
import com.example.movieapp.data.data.network.ApiService
import com.example.movieapp.data.repository.datasources.MovieRepositoryImpl
import com.example.movieapp.domain.repositories.MovieRepository

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    @Singleton
    fun providesMovieRepositoryImpl(
        apiService: ApiService,
        movieDatabase: MovieDatabase,
        @ApplicationContext context: Context
    ): MovieRepository = MovieRepositoryImpl(movieDatabase, context)

}