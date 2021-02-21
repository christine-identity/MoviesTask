package com.example.myapplication

import com.google.gson.annotations.SerializedName

//MoviesList
data class Movies(
    @SerializedName("page") val page: Int,
    @SerializedName("results") val movies: List<Result>,
    @SerializedName("total_pages") val pages: Int,
    @SerializedName("total_results")val total_results: Int
)