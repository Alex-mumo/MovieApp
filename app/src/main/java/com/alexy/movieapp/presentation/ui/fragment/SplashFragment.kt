package com.alexy.movieapp.presentation.ui.fragment

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.alexy.movieapp.R
import com.alexy.movieapp.databinding.FragmentSplashBinding


class SplashFragment : Fragment() {
    private lateinit var binding: FragmentSplashBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSplashBinding.bind(view)

        Handler(Looper.myLooper()!!).postDelayed({
            findNavController().navigate(R.id.action_splashFragment_to_movieFragment)
        }, 3000)
    }
}