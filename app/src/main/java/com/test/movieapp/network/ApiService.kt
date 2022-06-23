package com.test.movieapp.network

import com.test.movieapp.model.Movie
import com.test.movieapp.model.response.SearchResponse
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("/")
    fun getMovies(@Query("apiKey") apiKey: String,
                  @Query("s") query: String,
                  @Query("page") page: Int
    ): Deferred<SearchResponse<List<Movie>>>
}