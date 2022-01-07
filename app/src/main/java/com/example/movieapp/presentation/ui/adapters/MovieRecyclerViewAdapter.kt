package com.example.movieapp.presentation.ui.adapters

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.domain.model.Movies

class MovieRecyclerViewAdapter constructor(private val movies: List<Movies>) : RecyclerView.Adapter<MovieRecyclerViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieRecyclerViewHolder {
        TODO("Not yet implemented")
    }

    //display the data at specified position
    override fun onBindViewHolder(holder: MovieRecyclerViewHolder, position: Int) {
        TODO()
    }

    override fun getItemCount(): Int {
        return movies.size
    }
}

class MovieRecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

}
