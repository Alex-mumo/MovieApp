package com.example.movieapp.domain.di

import com.example.movieapp.domain.usecase.FetchMovies
import org.koin.dsl.module

val domainModule = module {
    single { FetchMovies(get()) }
}