package com.alexy.movieapp.presentation.di

import com.alexy.movieapp.presentation.ui.viewmodel.MovieViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel { MovieViewModel(get()) }
}