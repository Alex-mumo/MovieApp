package com.example.movieapp.domain.di

import com.example.movieapp.domain.repositories.DetailRepository
import com.example.movieapp.domain.repositories.MovieRepository
import com.example.movieapp.domain.usecases.GetCastUseCase
import com.example.movieapp.domain.usecases.GetMovieUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DomainModule {

    @Provides
    @Singleton
    fun providesCastUseCase(detailRepository: DetailRepository) =
        GetCastUseCase(detailRepository)

    @Provides
    @Singleton
    fun providesMovieUseCase(movieRepository: MovieRepository) =
        GetMovieUseCase(movieRepository)

}