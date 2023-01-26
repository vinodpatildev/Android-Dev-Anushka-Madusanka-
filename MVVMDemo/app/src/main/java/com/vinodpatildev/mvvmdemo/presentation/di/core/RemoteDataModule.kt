package com.vinodpatildev.mvvmdemo.presentation.di.core

import com.vinodpatildev.mvvmdemo.data.api.TMDBService
import com.vinodpatildev.mvvmdemo.data.repository.artist.datasource.ArtistRemoteDataSource
import com.vinodpatildev.mvvmdemo.data.repository.artist.datasourceimpl.ArtistRemoteDataSourceImpl
import com.vinodpatildev.mvvmdemo.data.repository.movie.datasource.MovieRemoteDataSource
import com.vinodpatildev.mvvmdemo.data.repository.movie.datasourceimpl.MovieRemoteDataSourceImpl
import com.vinodpatildev.mvvmdemo.data.repository.tvshow.datasource.TvShowRemoteDataSource
import com.vinodpatildev.mvvmdemo.data.repository.tvshow.datasourceImpl.TvShowRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class RemoteDataModule(private val apiKey: String) {
    @Singleton
    @Provides
    fun provideMovieRemoteDataSource(tmdbService: TMDBService): MovieRemoteDataSource {
        return MovieRemoteDataSourceImpl(
            tmdbService, apiKey
        )
    }

    @Singleton
    @Provides
    fun provideTvRemoteDataSource(tmdbService: TMDBService): TvShowRemoteDataSource {
        return TvShowRemoteDataSourceImpl(
            tmdbService, apiKey
        )
    }

    @Singleton
    @Provides
    fun provideArtistRemoteDataSource(tmdbService: TMDBService): ArtistRemoteDataSource {
        return ArtistRemoteDataSourceImpl(
            tmdbService, apiKey
        )
    }


}