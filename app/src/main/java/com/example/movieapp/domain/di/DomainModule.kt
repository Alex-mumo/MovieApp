package com.example.movieapp.domain.di

import com.example.movieapp.domain.usecase.FetchMovies
import com.example.movieapp.domain.usecase.FetchMoviesById
import org.koin.dsl.module

val domainModule = module {
    single { FetchMovies(get()) }
    single { FetchMoviesById(get()) }
}