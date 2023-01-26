package com.vinodpatildev.mvvmdemo.presentation.di.core

import com.vinodpatildev.mvvmdemo.data.db.ArtistDao
import com.vinodpatildev.mvvmdemo.data.db.MovieDao
import com.vinodpatildev.mvvmdemo.data.db.TvShowDao
import com.vinodpatildev.mvvmdemo.data.repository.artist.datasource.ArtistLocalDataSource
import com.vinodpatildev.mvvmdemo.data.repository.artist.datasourceimpl.ArtistLocalDataSourceImpl
import com.vinodpatildev.mvvmdemo.data.repository.movie.datasource.MovieLocalDataSource
import com.vinodpatildev.mvvmdemo.data.repository.movie.datasourceimpl.MovieLocalDataSourceImpl
import com.vinodpatildev.mvvmdemo.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.vinodpatildev.mvvmdemo.data.repository.tvshow.datasourceImpl.TvShowLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class LocalDataModule {

    @Singleton
    @Provides
    fun provideMovieLocalDataSource(movieDao: MovieDao): MovieLocalDataSource {
        return MovieLocalDataSourceImpl(movieDao)
    }

    @Singleton
    @Provides
    fun provideTvShowLocalDataSource(tvShowDao: TvShowDao): TvShowLocalDataSource {
        return TvShowLocalDataSourceImpl(tvShowDao)
    }

    @Singleton
    @Provides
    fun provideArtistLocalDataSource(artistDao : ArtistDao): ArtistLocalDataSource {
        return ArtistLocalDataSourceImpl(artistDao)
    }


}