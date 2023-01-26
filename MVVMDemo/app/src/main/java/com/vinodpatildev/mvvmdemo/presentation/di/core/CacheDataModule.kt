package com.vinodpatildev.mvvmdemo.presentation.di.core

import com.vinodpatildev.mvvmdemo.data.repository.artist.datasource.ArtistCacheDataSource
import com.vinodpatildev.mvvmdemo.data.repository.artist.datasourceimpl.ArtistCacheDataSourceImpl
import com.vinodpatildev.mvvmdemo.data.repository.movie.datasource.MovieCacheDataSource
import com.vinodpatildev.mvvmdemo.data.repository.movie.datasourceimpl.MovieCacheDataSourceImpl
import com.vinodpatildev.mvvmdemo.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.vinodpatildev.mvvmdemo.data.repository.tvshow.datasourceImpl.TvShowCacheDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule {
    @Singleton
    @Provides
    fun provideMovieCacheDataSource(): MovieCacheDataSource {
        return MovieCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideTvShowCacheDataSource(): TvShowCacheDataSource {
        return TvShowCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideArtistCacheDataSource(): ArtistCacheDataSource {
        return ArtistCacheDataSourceImpl()
    }


}