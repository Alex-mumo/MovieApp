package com.example.movieapp.data.repository.di

import com.example.movieapp.data.repository.datasources.MovieDetailRepositoryImpl
import com.example.movieapp.data.repository.datasources.MovieRepositoryImpl
import com.example.movieapp.domain.repositories.DetailRepository
import com.example.movieapp.domain.repositories.MovieRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<MovieRepository> { MovieRepositoryImpl(get(), get()) }
    single<DetailRepository> { MovieDetailRepositoryImpl(get(), get())}
}