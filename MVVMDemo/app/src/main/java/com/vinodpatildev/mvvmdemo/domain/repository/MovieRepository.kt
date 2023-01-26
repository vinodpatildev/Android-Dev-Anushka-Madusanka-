package com.vinodpatildev.mvvmdemo.domain.repository

import com.vinodpatildev.mvvmdemo.data.model.movie.Movie

interface MovieRepository {

    suspend fun getMovies():List<Movie>?

    suspend fun updateMovies():List<Movie>?
}