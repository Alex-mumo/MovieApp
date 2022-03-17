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
import com.example.movieapp.data.data.network.MovieResponse
import com.example.movieapp.data.ui.adapter.MovieAdapter

import com.example.movieapp.data.ui.viewmodel.MovieViewModel
import com.example.movieapp.data.utils.Resource
import com.example.movieapp.databinding.FragmentMovieBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import timber.log.Timber


@AndroidEntryPoint
class MovieFragment : Fragment(R.layout.fragment_movie) {
    private lateinit var binding: FragmentMovieBinding
    private lateinit var movieAdapter: MovieAdapter
    private val viewModel: MovieViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMovieBinding.inflate(inflater, container, false)

        subscribeObserver()
        setUpAdapter()
        return binding.root
    }

    private fun setUpAdapter() {
        binding.movieRecycler.apply {
            adapter = movieAdapter
        }

    }

    private fun subscribeObserver() {
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.fetchMovies()
        }
    }
}