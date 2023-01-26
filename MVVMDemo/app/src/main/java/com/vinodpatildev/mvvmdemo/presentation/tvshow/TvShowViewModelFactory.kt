package com.vinodpatildev.mvvmdemo.presentation.tvshow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.vinodpatildev.mvvmdemo.domain.usecases.GetTvShowsUseCase
import com.vinodpatildev.mvvmdemo.domain.usecases.UpdateArtistUseCase
import com.vinodpatildev.mvvmdemo.domain.usecases.UpdateTvShowsUseCase

class TvShowViewModelFactory(
    private val getTvShowsUseCase: GetTvShowsUseCase,
    private val updateTvShowUseCase: UpdateTvShowsUseCase
): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//        return super.create(modelClass)
        return TvShowViewModel(getTvShowsUseCase,updateTvShowUseCase) as T
    }
}