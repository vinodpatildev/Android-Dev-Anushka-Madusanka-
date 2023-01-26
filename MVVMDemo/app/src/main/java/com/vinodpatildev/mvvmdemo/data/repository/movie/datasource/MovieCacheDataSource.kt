package com.vinodpatildev.mvvmdemo.data.repository.movie.datasource

import com.vinodpatildev.mvvmdemo.data.model.movie.Movie

interface MovieCacheDataSource {
    suspend fun getMoviesFromCache():List<Movie>
    suspend fun saveMoviesToCache(movies:List<Movie>)
}