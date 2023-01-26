package com.vinodpatildev.mvvmdemo.presentation.di.tvshow

import com.vinodpatildev.mvvmdemo.domain.usecases.GetTvShowsUseCase
import com.vinodpatildev.mvvmdemo.domain.usecases.UpdateTvShowsUseCase
import com.vinodpatildev.mvvmdemo.presentation.tvshow.TvShowViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class TvShowModule {
    @TvShowScope
    @Provides
    fun provideTvShowViewModelFactory(
        getTvShowsUseCase: GetTvShowsUseCase,
        updateTvShowsUseCase: UpdateTvShowsUseCase
    ): TvShowViewModelFactory {
        return TvShowViewModelFactory(
            getTvShowsUseCase,
            updateTvShowsUseCase
        )
    }
}