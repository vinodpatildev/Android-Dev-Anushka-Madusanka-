package com.vinodpatildev.mvvmdemo.presentation.di.core

import android.content.Context
import androidx.room.Room
import com.vinodpatildev.mvvmdemo.data.db.ArtistDao
import com.vinodpatildev.mvvmdemo.data.db.MovieDao
import com.vinodpatildev.mvvmdemo.data.db.TMDBDatabase
import com.vinodpatildev.mvvmdemo.data.db.TvShowDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataBaseModule {
    @Singleton
    @Provides
    fun provideMovieDataBase(context: Context):TMDBDatabase{
     return Room.databaseBuilder(context, TMDBDatabase::class.java,"tmdbclient")
         .build()
    }
    @Singleton
    @Provides
    fun provideMovieDao(tmdbDatabase: TMDBDatabase): MovieDao {
        return tmdbDatabase.movieDao()
    }

    @Singleton
    @Provides
    fun provideTvShowDao(tmdbDatabase: TMDBDatabase): TvShowDao {
        return tmdbDatabase.tvShowDao()
    }

    @Singleton
    @Provides
    fun provideArtistDao(tmdbDatabase: TMDBDatabase): ArtistDao {
        return tmdbDatabase.artistDao()
    }





}