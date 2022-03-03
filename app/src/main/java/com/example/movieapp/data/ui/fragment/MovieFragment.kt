package com.example.movieapp.data.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movieapp.R
import com.example.movieapp.data.data.database.entity.Movie
import com.example.movieapp.data.ui.adapter.MovieAdapter

import com.example.movieapp.data.ui.viewmodel.MovieViewModel
import com.example.movieapp.data.utils.Resource
import com.example.movieapp.databinding.FragmentMovieBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import timber.log.Timber


@AndroidEntryPoint
class MovieFragment : Fragment(R.layout.fragment_movie) {
    private var _binding: FragmentMovieBinding? = null
    private val binding get() = _binding!!
    private lateinit var movieAdapter: MovieAdapter
    private val viewModel by viewModels<MovieViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMovieBinding.inflate(inflater, container, false)
        return binding.root
        //return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
       // binding = FragmentMovieBinding.bind(view)

        initRecyclerView()
        initMovies()
    }

    private fun initRecyclerView() {
        viewModel.getMovies.observe(viewLifecycleOwner, {
            recyclerViewMovies(it)
        })
    }

    private fun initMovies() {
        viewModel.movieResponse.observe(viewLifecycleOwner, Observer {
            when(it){
                is Resource.Success ->{
                    lifecycleScope.launch {
                        viewModel.saveMovies(it.value.results)
                        recyclerViewMovies(it.value.results)
                    }
                }
                is Resource.Error -> {
                    Timber.d("Failed to fetch")
                }
                else -> {
                    Timber.d("Network error")
                }
            }
        })
    }
    private fun recyclerViewMovies(movies: List<Movie>) {

        binding.movieRecycler.apply {
            movieAdapter = MovieAdapter(movies)
            adapter = movieAdapter
            hasFixedSize()
            binding.movieRecycler.adapter
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        }

    }
}