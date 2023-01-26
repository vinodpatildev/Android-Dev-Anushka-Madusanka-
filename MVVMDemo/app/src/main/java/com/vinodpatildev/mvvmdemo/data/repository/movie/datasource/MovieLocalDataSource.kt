package com.vinodpatildev.mvvmdemo.data.repository.movie.datasource

import com.vinodpatildev.mvvmdemo.data.model.movie.Movie

interface MovieLocalDataSource {
    suspend fun getMoviesFromDB():List<Movie>
    suspend fun saveMoviesToDB(movies:List<Movie>)
    suspend fun clearAll()
}