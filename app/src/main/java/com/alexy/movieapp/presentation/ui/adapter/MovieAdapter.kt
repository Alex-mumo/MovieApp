package com.alexy.movieapp.presentation.ui.adapter



import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.alexy.movieapp.databinding.MovieItemBinding
import com.alexy.movieapp.domain.models.MovieShow
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions

class MovieAdapter(private val onClickListener: OnClickListener): RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    class MovieViewHolder(val binding: MovieItemBinding): RecyclerView.ViewHolder(binding.root)

        private val differCallback = object : DiffUtil.ItemCallback<MovieShow>() {
            override fun areItemsTheSame(oldItem: MovieShow, newItem: MovieShow): Boolean {
                return oldItem.id == newItem.id
            }
            override fun areContentsTheSame(oldItem: MovieShow, newItem: MovieShow): Boolean {
                return oldItem == newItem
            }
        }
        val differ = AsyncListDiffer(this, differCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: MovieItemBinding =  MovieItemBinding.inflate(layoutInflater, parent, false)
        return MovieViewHolder(binding)
    }
    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = differ.currentList[position]
        holder.binding.apply {
            Glide.with(this.root)
                .load(movie.image)
                .transition(DrawableTransitionOptions.withCrossFade(500))
                .into(imageurl)
        }
    }
    class OnClickListener(val clickListener: (movies: MovieShow) -> Unit) {
        fun onClick(movies: MovieShow) = clickListener(movies)
    }

    override fun getItemCount(): Int = differ.currentList.size
    }
