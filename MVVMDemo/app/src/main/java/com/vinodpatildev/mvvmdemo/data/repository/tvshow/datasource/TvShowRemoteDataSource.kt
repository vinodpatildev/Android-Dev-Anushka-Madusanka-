package com.vinodpatildev.mvvmdemo.data.repository.tvshow.datasource

import com.vinodpatildev.mvvmdemo.data.model.tvshow.TvShowList
import retrofit2.Response


interface TvShowRemoteDataSource {
   suspend fun getTvShows(): Response<TvShowList>
}