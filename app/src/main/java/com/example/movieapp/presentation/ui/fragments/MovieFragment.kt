package com.example.movieapp.presentation.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.movieapp.databinding.FragmentMovieBinding


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