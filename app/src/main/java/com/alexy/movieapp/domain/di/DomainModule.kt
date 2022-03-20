package com.example.movieapp.domain.di

import com.example.movieapp.domain.usecases.GetMovieUseCase
import org.koin.dsl.module

val domainModule = module {
    single { GetMovieUseCase(get()) }
    single { GetMovieUseCase(get()) }
}