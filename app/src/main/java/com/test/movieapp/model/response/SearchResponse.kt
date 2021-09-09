package com.test.movieapp.model.response

import com.google.gson.annotations.SerializedName

class SearchResponse<T> (
    @SerializedName("Search")
    val results: T,
    @SerializedName("totalResults")
    val totalResults: Long,
    @SerializedName("Response")
    val response: Boolean
)