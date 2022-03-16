package com.example.movieapp.data.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieapp.R

import com.example.movieapp.data.data.database.entity.Movie
import com.example.movieapp.data.ui.fragment.MovieFragmentDirections
import com.example.movieapp.data.utils.MovieComparator
import com.example.movieapp.databinding.MovieItemBinding

class MovieAdapter: ListAdapter<Movie,MovieAdapter.MovieViewHolder>(
    MovieComparator()) {

    inner class MovieViewHolder(val binding: MovieItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: Movie) {
            Glide.with(binding.imageurl)
                .load(movie.backdrop_path)
                .placeholder(R.drawable.ic_launcher_background)
                .centerCrop()
                .into(binding.imageurl)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val movieItemBinding = MovieItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(movieItemBinding)
    }

    override fun getItemCount() = currentList.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) = with(holder.binding) {

        val movie = getItem(position)
        holder.itemView.setOnClickListener {

        }
        holder.bind(movie)

        title.text = movie.title
        releaseDate.text = movie.release_date
        average.text = movie.vote_count.toString()

        movieCardView.setOnClickListener {
            val action = MovieFragmentDirections.actionMovieFragmentToDetailFragment(movie)
            Navigation.findNavController(it).navigate(action)
        }
    }

}