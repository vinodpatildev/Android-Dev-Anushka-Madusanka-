package com.vinodpatildev.mvvmdemo.data.model.movie
import com.google.gson.annotations.SerializedName
import com.vinodpatildev.mvvmdemo.data.model.movie.Movie

data class MovieList(
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val movies: List<Movie>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)