package com.test.movieapp.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.test.movieapp.model.Movie
import com.test.movieapp.network.ApiService
import java.lang.Exception

private const val FIRST_PAGE = 0
private const val API_KEY = "e67c566e"
class MovieDataSource(
    private val query: String,
    private val apiService: ApiService
): PagingSource<Int, Movie>() {
    override fun getRefreshKey(state: PagingState<Int, Movie>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Movie> {
        try {
            val nextPageNumber = params.key ?: FIRST_PAGE
            val response = apiService.getMovies(API_KEY, query, nextPageNumber).await()
            return LoadResult.Page(
                data = response.results,
                prevKey = null, // Only paging forward.
                nextKey = nextPageNumber + 1
            )
        } catch (ex: Exception) {
            return LoadResult.Error(
                ex
            )
        }
    }
}