package com.example.movieapp.data.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.movieapp.R
import com.example.movieapp.data.ui.adapter.MovieAdapter
import com.example.movieapp.data.ui.viewmodel.MovieViewModel
import com.example.movieapp.databinding.FragmentMovieBinding
import dagger.hilt.android.AndroidEntryPoint

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
        movieAdapter = MovieAdapter(MovieAdapter.OnClickListener {  movie ->
            val action = MovieFragmentDirections.actionMovieFragmentToDetailFragment(movie)
            findNavController().navigate(action)
        })

        return binding.root
    }
}