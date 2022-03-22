package com.alexy.movieapp.presentation.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.alexy.movieapp.R
import com.alexy.movieapp.presentation.ui.adapter.MovieAdapter
import com.alexy.movieapp.presentation.ui.viewmodel.MovieViewModel
import com.alexy.movieapp.databinding.FragmentMovieBinding
import com.alexy.movieapp.domain.models.MovieShow
import com.alexy.movieapp.presentation.utils.Resource
import org.koin.androidx.viewmodel.ext.android.viewModel
import kotlinx.coroutines.launch

class MovieFragment : Fragment(R.layout.fragment_movie) {
    private var _binding: FragmentMovieBinding? = null
    private val binding get() = _binding!!
    private val viewModel: MovieViewModel by viewModel()
    private lateinit var movieAdapter: MovieAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentMovieBinding.bind(view)

        setUpUi()
    }

    private fun setUpUi() {
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.popularMovies.collect { result ->
                when(result) {
                    is Resource.Success -> {
                        binding.progressBar.isVisible = false
                        binding.movieRecycler.isVisible = true
                        if (result.data.isEmpty()) {
                            Toast.makeText(requireContext(), "No Movies")
                        } else {

                        }
                    }
                    is Resource.Error -> {

                    }
                    is Resource.Loading -> {
                        binding.progressBar.isVisible = true
                    }

                }
            }
        }


        /*
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewLifecycleOwner.lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED){
                launch {
                    viewModel.popularMovies.collect { resource ->
                        when(resource) {
                            is Resource.Loading -> {
                                binding.progressBar.isVisible = true
                                //Toast.makeText(requireContext(), "Error", Toast.LENGTH_LONG).show()
                            }
                            is Resource.Success -> {
                                binding.progressBar.isVisible = false
                                binding.movieRecycler.isVisible = true
                                if(resource.data.isEmpty()){
                                    Toast.makeText(requireContext(), "No Movies", Toast.LENGTH_LONG).show()
                                } else {
                                    val movieShow = resource.data
                                    movieAdapter.submitList(movieShow)
                                    binding.movieRecycler.adapter = movieAdapter

                                }

                            //fetchMovies(resource.data)

                            }
                            is Resource.Error -> {
                                //Toast.makeText(requireContext(), "Error", Toast.LENGTH_LONG).show()
                            }
                        }
                    }
                }
            }
        }*/
    }
    /*
    private fun fetchMovies(movies: List<MovieShow>) {
        if (!movies.isNullOrEmpty()){
            val movieAdapter = MovieAdapter(movies)
            binding.movieRecycler.adapter = movieAdapter

        }

    }*/

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}