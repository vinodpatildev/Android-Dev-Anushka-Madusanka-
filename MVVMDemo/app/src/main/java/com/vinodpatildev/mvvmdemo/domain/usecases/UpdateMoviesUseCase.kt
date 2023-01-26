package com.vinodpatildev.mvvmdemo.domain.usecases

import com.vinodpatildev.mvvmdemo.data.model.movie.Movie
import com.vinodpatildev.mvvmdemo.domain.repository.MovieRepository

class UpdateMoviesUseCase(private val movieRepository: MovieRepository) {

    suspend fun execute():List<Movie>? = movieRepository.updateMovies()
}