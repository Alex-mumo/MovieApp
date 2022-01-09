package com.example.movieapp.presentation.ui.adapters

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.movieapp.domain.model.Movies

class MovieRecyclerViewAdapter constructor(private val movies: List<Movies>) : RecyclerView.Adapter<MovieRecyclerViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieRecyclerViewHolder {
        TODO("Not yet implemented")
    }

    //display the data at specified position
    override fun onBindViewHolder(holder: MovieRecyclerViewHolder, position: Int) {
        val movieItem = movies[position]
        val context = holder.itemView.context
        holder.bind(context, movieItem)
        holder.itemView.setOnClickListener {
            
        }
    }

    override fun getItemCount(): Int {
        return movies.size
    }
}

class MovieRecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(context: Context?, movieItem: Movies) {
        Glide.with(context)
            .load(movieItem.image)
            .transition(DrawableTransitionOptions.withCrossFade(400))
            .into()

    }

}
