package com.example.movieapp.presentation.ui.viewmodel

import androidx.lifecycle.*
import com.example.movieapp.domain.usecases.GetMovieUseCase
import com.example.movieapp.presentation.utils.Resource

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(private val getMovieUseCase: GetMovieUseCase): ViewModel() {

    private val _popularMovies = MutableStateFlow<Resource>(Resource.Loading)
    val popularMovies: StateFlow<Resource> = _popularMovies

    init {
        getPopularMovies()
    }

    private fun getPopularMovies() = viewModelScope.launch {
        try {
            val response = getMovieUseCase.invoke()
            response.collect {
                _popularMovies.value = Resource.Success(it)
            }
        } catch (e: HttpException) {

        } catch (e: IOException) {

        }

    }
}