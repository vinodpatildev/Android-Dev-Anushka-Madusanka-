package com.vinodpatildev.mvvmdemo.presentation.tvshow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.vinodpatildev.mvvmdemo.domain.usecases.GetTvShowsUseCase
import com.vinodpatildev.mvvmdemo.domain.usecases.UpdateArtistUseCase
import com.vinodpatildev.mvvmdemo.domain.usecases.UpdateTvShowsUseCase

class TvShowViewModel(
    private val getTvShowsUseCase: GetTvShowsUseCase,
    private val updateTvShowUseCase: UpdateTvShowsUseCase
):ViewModel() {
    fun getTvShows() = liveData {
        val tvShowsList = getTvShowsUseCase.execute()
        emit(tvShowsList)
    }
    fun updateTvShows() = liveData {
        val tvShowsList = updateTvShowUseCase.execute()
        emit(tvShowsList)
    }
}