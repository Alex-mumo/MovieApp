package com.alexy.movieapp.presentation.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.alexy.movieapp.R
import com.alexy.movieapp.data.cache.database.entity.Movie
import com.alexy.movieapp.presentation.ui.adapter.MovieAdapter
import com.alexy.movieapp.presentation.ui.viewmodel.MovieViewModel
import com.alexy.movieapp.databinding.FragmentMovieBinding
import com.alexy.movieapp.domain.models.MovieShow
import com.alexy.movieapp.presentation.utils.Resource
import org.koin.androidx.viewmodel.ext.android.viewModel
import kotlinx.coroutines.launch

class MovieFragment : Fragment(R.layout.fragment_movie) {
    private var _binding: FragmentMovieBinding? = null
    private val movieAdapter = MovieAdapter()
    private val binding get() = _binding!!
    private val viewModel: MovieViewModel by viewModel()
   // private lateinit var movieAdapter: MovieAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentMovieBinding.bind(view)

        setUpUi()
    }

    private fun setUpUi() {
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewLifecycleOwner.lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED){
                launch {
                    viewModel.popularMovies.collect {
                        when(it) {
                            is Resource.Loading -> {
                                binding.progressBar.isVisible = true
                            }
                            is Resource.Success -> {
                                binding.progressBar.isVisible = false
                                fetchMovies(it.data as List<MovieShow>)
                            }
                            is Resource.Error -> {
                                Toast.makeText(requireContext(), "Error", Toast.LENGTH_LONG).show()
                            }
                        }
                    }
                }
            }
        }
    }

    private fun fetchMovies(movies: List<MovieShow>) {
        if (!movies.isNullOrEmpty()){
            val movieAdapter = MovieAdapter(movies){
                val action = MovieFragmentDirections.actionMovieFragmentToDetailFragment()
                findNavController().navigate(action)
            }
            binding.movieRecycler.adapter = movieAdapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}