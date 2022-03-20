package com.alexy.movieapp.domain.di

import com.alexy.movieapp.domain.usecases.GetCastUseCase
import com.alexy.movieapp.domain.usecases.GetMovieUseCase
import org.koin.dsl.module

val domainModule = module {
    single { GetMovieUseCase(get()) }
    single { GetCastUseCase(get()) }
}