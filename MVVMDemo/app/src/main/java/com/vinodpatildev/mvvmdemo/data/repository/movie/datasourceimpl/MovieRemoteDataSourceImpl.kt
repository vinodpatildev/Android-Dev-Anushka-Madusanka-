package com.vinodpatildev.mvvmdemo.data.repository.movie.datasourceimpl

import com.vinodpatildev.mvvmdemo.data.api.TMDBService
import com.vinodpatildev.mvvmdemo.data.model.movie.MovieList
import com.vinodpatildev.mvvmdemo.data.repository.movie.datasource.MovieRemoteDataSource
import retrofit2.Response

class MovieRemoteDataSourceImpl(private val tmdbService : TMDBService, private val apiKey : String): MovieRemoteDataSource {
    override suspend fun getMovies(): Response<MovieList> {
        return tmdbService.getPopularMovies(apiKey)
    }
}