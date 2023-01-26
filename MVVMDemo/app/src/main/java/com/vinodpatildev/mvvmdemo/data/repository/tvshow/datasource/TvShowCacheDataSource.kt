package com.vinodpatildev.mvvmdemo.data.repository.tvshow.datasource

import com.vinodpatildev.mvvmdemo.data.model.tvshow.TvShow


interface TvShowCacheDataSource {
    suspend fun getTvShowsFromCache():List<TvShow>
    suspend fun saveTvShowsToCache(tvShows:List<TvShow>)

}