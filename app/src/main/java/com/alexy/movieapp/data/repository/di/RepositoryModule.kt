package com.alexy.movieapp.data.repository.di

import com.alexy.movieapp.data.repository.datasources.MovieDetailRepositoryImpl
import com.alexy.movieapp.data.repository.datasources.MovieRepositoryImpl
import com.alexy.movieapp.domain.repositories.DetailRepository
import com.alexy.movieapp.domain.repositories.MovieRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<MovieRepository> { MovieRepositoryImpl(get(), get()) }
    single<DetailRepository> { MovieDetailRepositoryImpl(get(), get())}
}