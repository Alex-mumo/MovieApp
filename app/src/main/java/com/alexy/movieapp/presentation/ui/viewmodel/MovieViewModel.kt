package com.alexy.movieapp.presentation.ui.viewmodel

import androidx.lifecycle.*
import com.alexy.movieapp.domain.usecases.GetMovieUseCase
import com.alexy.movieapp.presentation.utils.Resource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.io.IOException
import java.net.UnknownHostException

class MovieViewModel constructor(private val getMovieUseCase: GetMovieUseCase): ViewModel() {

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
        } catch (e: UnknownHostException) {
            _popularMovies.value = Resource.Error(e.localizedMessage ?: "Internet")

        } catch (e: IOException) {
            _popularMovies.value = Resource.Error(e.localizedMessage ?: "unknown")
        }

    }
}