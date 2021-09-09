package com.test.movieapp.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.test.movieapp.model.Movie
import com.test.movieapp.network.ApiService
import com.test.movieapp.paging.MovieDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MovieRepository @Inject constructor(
    private val apiService: ApiService
): IMovieRepository {
    override fun getMovies(query: String): Flow<PagingData<Movie>> {
        return Pager(
            PagingConfig(pageSize = 10)
        ) {
            MovieDataSource(query, apiService)
        }.flow
    }
}