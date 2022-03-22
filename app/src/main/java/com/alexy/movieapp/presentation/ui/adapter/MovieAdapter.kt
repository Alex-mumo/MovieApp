package com.alexy.movieapp.presentation.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.alexy.movieapp.R
import com.alexy.movieapp.databinding.MovieItemBinding
import com.alexy.movieapp.domain.models.MovieShow
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions

class MovieAdapter(private val movies: List<MovieShow>, private val onClick: (MovieShow) -> Unit): RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = MovieItemBinding.inflate(layoutInflater)
        //val movieItemBinding = MovieItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movieShow = movies[position]
        val context = holder.itemView.context
        holder.bind(context, movieShow)

        holder.itemView.setOnClickListener {
            onClick(movieShow)
        }
    }
    inner class MovieViewHolder(private val binding: MovieItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(context: Context, movie: MovieShow) {
            Glide.with(context)
                .load(movie.image)
                .placeholder(R.drawable.ic_launcher_background)
                .centerCrop()
                .transition(DrawableTransitionOptions.withCrossFade(500))
                .into(binding.imageurl)
            binding.average.text = movie.title

        }
    }

    override fun getItemCount() = movies.size
}