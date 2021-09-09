package com.test.movieapp.viewmodel

import androidx.lifecycle.ViewModel
import com.test.movieapp.repository.IMovieRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flatMapLatest
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val repository: IMovieRepository
): ViewModel() {

    private val _searchQueryFlow  = MutableStateFlow<String>("")
    val searchQueryFlow: StateFlow<String> get() = _searchQueryFlow

    val movies = _searchQueryFlow.flatMapLatest {
        repository.getMovies(it)
    }

    fun getMoviesWith(query: String) {
        _searchQueryFlow.value = query
    }
}