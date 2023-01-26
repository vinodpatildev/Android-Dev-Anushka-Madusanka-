package com.vinodpatildev.mvvmdemo.domain.usecases

import com.vinodpatildev.mvvmdemo.data.model.tvshow.TvShow
import com.vinodpatildev.mvvmdemo.domain.repository.TvShowRepository

class GetTvShowsUseCase(private val tvShowRepository: TvShowRepository) {
    suspend fun execute():List<TvShow>? = tvShowRepository.getTvShows()
}