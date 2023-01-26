package com.vinodpatildev.mvvmdemo.presentation.di.core

import com.vinodpatildev.mvvmdemo.data.repository.artist.ArtistRepositoryImpl
import com.vinodpatildev.mvvmdemo.data.repository.artist.datasource.ArtistCacheDataSource
import com.vinodpatildev.mvvmdemo.data.repository.artist.datasource.ArtistLocalDataSource
import com.vinodpatildev.mvvmdemo.data.repository.artist.datasource.ArtistRemoteDataSource
import com.vinodpatildev.mvvmdemo.data.repository.movie.MovieRepositoryImpl
import com.vinodpatildev.mvvmdemo.data.repository.movie.datasource.MovieCacheDataSource
import com.vinodpatildev.mvvmdemo.data.repository.movie.datasource.MovieLocalDataSource
import com.vinodpatildev.mvvmdemo.data.repository.movie.datasource.MovieRemoteDataSource
import com.vinodpatildev.mvvmdemo.data.repository.tvshow.TvShowRepositoryImpl
import com.vinodpatildev.mvvmdemo.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.vinodpatildev.mvvmdemo.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.vinodpatildev.mvvmdemo.data.repository.tvshow.datasource.TvShowRemoteDataSource
import com.vinodpatildev.mvvmdemo.domain.repository.ArtistRepository
import com.vinodpatildev.mvvmdemo.domain.repository.MovieRepository
import com.vinodpatildev.mvvmdemo.domain.repository.TvShowRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class RepositoryModule {
    @Provides
    @Singleton
    fun provideMovieRepository(
        movieRemoteDatasource: MovieRemoteDataSource,
        movieLocalDataSource: MovieLocalDataSource,
        movieCacheDataSource: MovieCacheDataSource
    ): MovieRepository {
        return MovieRepositoryImpl(
            movieRemoteDatasource,
            movieLocalDataSource,
            movieCacheDataSource
        )
    }

    @Provides
    @Singleton
    fun provideTvShowRepository(
        tvShowRemoteDatasource: TvShowRemoteDataSource,
        tvShowLocalDataSource: TvShowLocalDataSource,
        tvShowCacheDataSource: TvShowCacheDataSource
    ): TvShowRepository {
        return TvShowRepositoryImpl(
            tvShowRemoteDatasource,
            tvShowLocalDataSource,
            tvShowCacheDataSource
        )
    }

    @Provides
    @Singleton
    fun provideArtistRepository(
        artistRemoteDatasource: ArtistRemoteDataSource,
        artistLocalDataSource: ArtistLocalDataSource,
        artistCacheDataSource: ArtistCacheDataSource
    ): ArtistRepository {
        return ArtistRepositoryImpl(
            artistRemoteDatasource,
            artistLocalDataSource,
            artistCacheDataSource
        )
    }

}