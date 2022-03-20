package com.alexy.movieapp.presentation.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.alexy.movieapp.R
import com.alexy.movieapp.databinding.FragmentDetailBinding

class DetailFragment : Fragment(R.layout.fragment_detail) {
    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentDetailBinding.bind(view)
    }
}