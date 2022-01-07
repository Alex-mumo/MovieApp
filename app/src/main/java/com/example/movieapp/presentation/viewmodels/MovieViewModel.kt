package com.example.movieapp.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapp.domain.usecase.FetchMovies
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

class MovieViewModel(private val getMovies: FetchMovies) : ViewModel() {
    init {
        getMovies()
    }



    private fun getMovies(){
        viewModelScope.launch {
            try {
                getMovies()

            }
            catch (e: HttpException) {

            }
            catch (e: IOException) {

            }
        }
    }
}