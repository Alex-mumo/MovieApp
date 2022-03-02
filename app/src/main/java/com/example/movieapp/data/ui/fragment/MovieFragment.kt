package com.example.movieapp.data.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movieapp.R
import com.example.movieapp.data.data.database.entity.Movie
import com.example.movieapp.data.ui.adapter.MovieRecyclerViewAdapter
import com.example.movieapp.data.ui.viewmodel.MovieViewModel
import com.example.movieapp.data.utils.Constants.API_KEY
import com.example.movieapp.data.utils.Resource
import com.example.movieapp.databinding.FragmentMovieBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import timber.log.Timber

@AndroidEntryPoint
class MovieFragment : Fragment(R.layout.fragment_movie) {
    private lateinit var binding: FragmentMovieBinding
    private val viewModel by viewModels<MovieViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentMovieBinding.bind(view)

        observeMovies()
        viewModel.fetchMovies()
        observeOffline()
    }

    private fun observeOffline() {
        viewModel.getMovies.observe(viewLifecycleOwner, {
            recyclerViewMovies(it)
        })
    }

    private fun observeMovies() {
        viewModel.movieResponse.observe(viewLifecycleOwner, Observer {
            when(it){
                is Resource.Success ->{
                    lifecycleScope.launch {
                        viewModel.saveMovies(it.value.results)
                        recyclerViewMovies(it.value.results)
                    }
                }
                is Resource.Error -> {
                    Timber.d("Network error")
                }
                else -> {
                    Timber.d("Failed")
                }
            }
        })
    }
    // Api key
    //fd65c1178171ce0d12871600b495fa47
    // Example API request
    //https://api.themoviedb.org/3/movie/550?api_key=fd65c1178171ce0d12871600b495fa47

    private fun recyclerViewMovies(movies: List<Movie>) {
        binding.movieRecycler.apply {
            layoutManager = LinearLayoutManager(requireActivity())
            hasFixedSize()
            adapter = MovieRecyclerViewAdapter(movies)
        }

    }
}