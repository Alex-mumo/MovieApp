package com.alexy.movieapp.presentation.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.alexy.movieapp.R
import com.alexy.movieapp.data.ui.adapter.MovieAdapter
import com.alexy.movieapp.presentation.ui.viewmodel.MovieViewModel
import com.alexy.movieapp.databinding.FragmentMovieBinding
import com.alexy.movieapp.domain.models.MovieShow
import com.alexy.movieapp.presentation.utils.Resource
import dagger.hilt.android.AndroidEntryPoint
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