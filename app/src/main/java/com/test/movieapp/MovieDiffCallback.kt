package com.test.movieapp

import androidx.recyclerview.widget.DiffUtil
import com.test.movieapp.model.Movie
import javax.inject.Inject

class MovieDiffCallback @Inject constructor(): DiffUtil.ItemCallback<Movie>() {
    override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
        return oldItem.imdbID == newItem.imdbID
    }

    override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
        return  oldItem == newItem
    }
}