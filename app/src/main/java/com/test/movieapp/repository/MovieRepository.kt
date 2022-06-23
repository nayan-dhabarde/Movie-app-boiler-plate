package com.test.movieapp.repository

import com.test.movieapp.network.ApiService
import javax.inject.Inject

class MovieRepository @Inject constructor(
    private val apiService: ApiService
) {

}