package com.vinodpatildev.mvvmdemo.data.repository.movie.datasource

import com.vinodpatildev.mvvmdemo.data.model.movie.MovieList
import retrofit2.Response

interface MovieRemoteDataSource {
    suspend fun getMovies(): Response<MovieList>
}