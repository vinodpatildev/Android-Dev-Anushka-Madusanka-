package com.vinodpatildev.mvvmdemo.data.repository.tvshow.datasourceImpl

import com.vinodpatildev.mvvmdemo.data.api.TMDBService
import com.vinodpatildev.mvvmdemo.data.model.tvshow.TvShowList
import com.vinodpatildev.mvvmdemo.data.repository.tvshow.datasource.TvShowRemoteDataSource
import retrofit2.Response


class TvShowRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey:String
): TvShowRemoteDataSource {
    override suspend fun getTvShows()
            : Response<TvShowList> = tmdbService.getPopularTvShows(apiKey)

}

