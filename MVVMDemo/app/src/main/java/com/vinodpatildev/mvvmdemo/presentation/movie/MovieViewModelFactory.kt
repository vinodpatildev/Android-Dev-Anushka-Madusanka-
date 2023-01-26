package com.vinodpatildev.mvvmdemo.presentation.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.vinodpatildev.mvvmdemo.domain.usecases.GetMoviesUseCase
import com.vinodpatildev.mvvmdemo.domain.usecases.UpdateMoviesUseCase

class MovieViewModelFactory(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val updateMoviesUseCase: UpdateMoviesUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//        return super.create(modelClass)
        return MovieViewModel(getMoviesUseCase,updateMoviesUseCase) as T
    }
}