package com.vinodpatildev.mvvmdemo.data.repository.tvshow.datasource

import com.vinodpatildev.mvvmdemo.data.model.tvshow.TvShow

interface TvShowLocalDataSource {
  suspend fun getTvShowsFromDB():List<TvShow>
  suspend fun saveTvShowsToDB(tvShows:List<TvShow>)
  suspend fun clearAll()
}