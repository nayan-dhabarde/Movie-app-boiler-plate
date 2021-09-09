package com.test.movieapp.repository

import androidx.paging.PagingData
import com.test.movieapp.model.Movie
import kotlinx.coroutines.flow.Flow

interface IMovieRepository {
    fun getMovies(query: String): Flow<PagingData<Movie>>
}