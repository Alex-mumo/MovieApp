package com.alexy.movieapp.presentation.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
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
    private lateinit var binding: FragmentMovieBinding
    //private lateinit var movieAdapter: MovieAdapter
    //private var _binding: FragmentMovieBinding? = null
    //private val movieAdapter = MovieAdapter()
    private lateinit var movieAdapter: MovieAdapter
    //private val binding get() = _binding!!
    private val viewModel: MovieViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMovieBinding.inflate(inflater, container, false)
        /*movieAdapter = MovieAdapter(MovieAdapter.OnClickListener {  movieShow ->
            val action = MovieFragmentDirections.actionMovieFragmentToDetailFragment(movieShow)
            findNavController().navigate(action)

        })

         */

        setUpUi()


        return binding.root
        //return super.onCreateView(inflater, container, savedInstanceState)
    }

   /* override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentMovieBinding.bind(view)

        setUpUi()
    }*/

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
                                binding.movieRecycler.isVisible = true
                                if (it.data.isEmpty()) {
                                    Toast.makeText(requireContext(), "No Movies", Toast.LENGTH_LONG).show()
                                }else {
                                    val movies = it.data
                                    movieAdapter.differ.submitList(movies)
                                    binding.movieRecycler.adapter = movieAdapter

                                }
                                //initPopularMovies(it.data)
                                //fetchMovies(it.data as List<MovieShow>)
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

    /*
    private fun initPopularMovies(movies: List<MovieShow>) {

    }



    private fun fetchMovies(movies: List<MovieShow>) {
        movieAdapter.differ.submitList(movies)
        binding.movieRecycler.adapter = movieAdapter
    }

     */
    /*override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

     */
}