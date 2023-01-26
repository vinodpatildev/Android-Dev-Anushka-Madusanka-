package com.vinodpatildev.mvvmdemo.data.repository.movie.datasourceimpl

import com.vinodpatildev.mvvmdemo.data.model.movie.Movie
import com.vinodpatildev.mvvmdemo.data.repository.movie.datasource.MovieCacheDataSource

class MovieCacheDataSourceImpl:MovieCacheDataSource {
    private var movieList = ArrayList<Movie>()
    override suspend fun getMoviesFromCache(): List<Movie> {
        return movieList
    }

    override suspend fun saveMoviesToCache(movies: List<Movie>) {
        movieList.clear()
        movieList = ArrayList(movies)
    }
}