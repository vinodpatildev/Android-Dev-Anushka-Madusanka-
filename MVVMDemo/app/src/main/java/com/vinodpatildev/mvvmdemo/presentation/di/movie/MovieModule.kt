package com.vinodpatildev.mvvmdemo.presentation.di.movie

import com.vinodpatildev.mvvmdemo.domain.usecases.GetMoviesUseCase
import com.vinodpatildev.mvvmdemo.domain.usecases.UpdateMoviesUseCase
import com.vinodpatildev.mvvmdemo.presentation.movie.MovieViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MovieModule {
    @MovieScope
    @Provides
    fun provideMovieViewModelFactory(
        getMoviesUseCase: GetMoviesUseCase,
        updateMoviesUseCase: UpdateMoviesUseCase
    ): MovieViewModelFactory {
        return MovieViewModelFactory(
            getMoviesUseCase,
            updateMoviesUseCase
        )
    }

}