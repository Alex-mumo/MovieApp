package com.example.movieapp.data.ui.viewmodel

import androidx.lifecycle.*
import com.example.movieapp.data.data.database.entity.Movie
import com.example.movieapp.data.data.network.MovieResponse
import com.example.movieapp.data.data.repository.MovieRepository
import com.example.movieapp.data.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(
    private val movieRepository: MovieRepository
    ): ViewModel() {

    private val _movieResponse: MutableLiveData<Resource<MovieResponse>> = MutableLiveData()
    val movieResponse: LiveData<Resource<MovieResponse>>
    get() = _movieResponse

    //var getMovies = movieRepository.fetchMoviesDb().asLiveData()

    fun saveMovies(movie: List<Movie>) = viewModelScope.launch{
        movieRepository.saveMovie(movie)
    }

    fun fetchMovies() = viewModelScope.launch {

        _movieResponse.value = movieRepository.getMovies("apiKey")
    }
}