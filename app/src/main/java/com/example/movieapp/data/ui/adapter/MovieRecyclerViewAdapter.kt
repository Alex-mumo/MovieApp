package com.example.movieapp.data.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.movieapp.data.data.database.entity.Movie
import com.example.movieapp.databinding.MovieItemBinding

class MovieRecyclerViewAdapter(
    private val movie: List<Movie>
    ) : RecyclerView.Adapter<MovieRecyclerViewAdapter.MovieViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MovieViewHolder (
        MovieItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) = with(holder.binding) {
        val movie = movie[position]

        val context = holder.itemView.context
        Glide.with(context)
            .load(movie.poster_path)
            .transition(DrawableTransitionOptions.withCrossFade())
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(imageurl)
        title.text = movie.title
        releaseDate.text = movie.release_date

    }

    override fun getItemCount() = movie.size

    class MovieViewHolder(val binding: MovieItemBinding): RecyclerView.ViewHolder(binding.root) {

    }

}