package com.alexy.movieapp.presentation.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.alexy.movieapp.R
import com.alexy.movieapp.databinding.MovieItemBinding
import com.alexy.movieapp.domain.models.MovieShow
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions

class MovieAdapter: RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    class MovieViewHolder(private val binding: MovieItemBinding): RecyclerView.ViewHolder(binding.root) {

        private val differCallback = object : DiffUtil.ItemCallback<MovieShow>() {
            override fun areItemsTheSame(oldItem: MovieShow, newItem: MovieShow): Boolean {
                return oldItem.id == newItem.id
            }
            override fun areContentsTheSame(oldItem: MovieShow, newItem: MovieShow): Boolean {
                return oldItem == newItem
            }
        }
        val differ = AsyncListDiffer(this, differCallback)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = MovieItemBinding.inflate(layoutInflater, parent, false)
        return MovieViewHolder(binding)
    }
    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {

        val context = holder.itemView.context
        holder.bind(context, movieShow)

        holder.itemView.setOnClickListener {
            onClick(movieShow)
        }
    }
    /*
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
    */
    override fun getItemCount() = movies.size
}