package com.vinodpatildev.mvvmdemo.domain.repository

import com.vinodpatildev.mvvmdemo.data.model.tvshow.TvShow

interface TvShowRepository {

    suspend fun getTvShows():List<TvShow>?

    suspend fun updateTvShow():List<TvShow>?
}