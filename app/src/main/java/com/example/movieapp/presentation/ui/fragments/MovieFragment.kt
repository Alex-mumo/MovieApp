package com.example.movieapp.presentation.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.movieapp.R
import com.example.movieapp.databinding.FragmentMovieBinding
import com.example.movieapp.presentation.viewmodels.MovieViewModel


class MovieFragment : Fragment() {
    private lateinit var binding : FragmentMovieBinding



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMovieBinding.inflate(layoutInflater)

       // private val movieViewModel: MovieViewModel by viewModel()
        return binding.root
    }
}