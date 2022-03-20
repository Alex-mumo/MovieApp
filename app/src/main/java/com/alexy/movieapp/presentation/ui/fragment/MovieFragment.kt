package com.example.movieapp.presentation.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.movieapp.R
import com.example.movieapp.data.ui.adapter.MovieAdapter
import com.example.movieapp.presentation.ui.viewmodel.MovieViewModel
import com.example.movieapp.databinding.FragmentMovieBinding
import com.example.movieapp.domain.models.MovieShow
import com.example.movieapp.presentation.utils.Resource
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MovieFragment : Fragment(R.layout.fragment_movie) {
    private var _binding: FragmentMovieBinding? = null
    private val binding get() = _binding!!
    //private lateinit var movieAdapter: MovieAdapter
    private val viewModel: MovieViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentMovieBinding.bind(view)

        setUpUi()
    }

    private fun setUpUi() {
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewLifecycleOwner.lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED){
                launch {
                    viewModel.popularMovies.collect { resource ->
                        when(resource) {
                            is Resource.Loading -> {

                            }
                            is Resource.Success -> {
                                fetchMovies(resource.data)
                            }
                            is Resource.Error -> {
                                TODO()
                            }
                        }
                    }
                }
            }
        }
    }

    private fun fetchMovies(movies: List<MovieShow>) {
        val movieAdapter = MovieAdapter(movies)
        binding.movieRecycler.adapter = movieAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}