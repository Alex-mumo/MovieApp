package com.example.movieapp.data.ui.viewmodel

import androidx.lifecycle.*
import com.example.movieapp.data.data.cache.database.entity.Movie
import com.example.movieapp.data.cache.repository.MovieRepository
import com.example.movieapp.data.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(
    private val movieRepository: MovieRepository
    ): ViewModel() {

    //private val _movieResponse: MutableLiveData<Resource<MovieResponse>> = MutableLiveData()
    //val movieResponse: LiveData<Resource<MovieResponse>>

    suspend fun fetchMovies(query: String): Flow<Resource<List<Movie>>> {
        return movieRepository.fetchMovies(query)
    }
}