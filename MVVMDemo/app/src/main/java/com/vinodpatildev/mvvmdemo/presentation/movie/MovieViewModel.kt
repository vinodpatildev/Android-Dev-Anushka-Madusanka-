package com.vinodpatildev.mvvmdemo.presentation.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.vinodpatildev.mvvmdemo.data.model.movie.Movie
import com.vinodpatildev.mvvmdemo.domain.usecases.GetMoviesUseCase
import com.vinodpatildev.mvvmdemo.domain.usecases.UpdateMoviesUseCase

class MovieViewModel(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val updateMoviesUseCase: UpdateMoviesUseCase
) : ViewModel() {
    fun getMovies() = liveData {
        val movieList = getMoviesUseCase.execute()
        emit(movieList)
    }
    fun updateMovies()  = liveData {
        val movieList = updateMoviesUseCase.execute()
        emit(movieList)
    }
}