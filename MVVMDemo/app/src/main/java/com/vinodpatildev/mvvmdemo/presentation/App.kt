package com.vinodpatildev.mvvmdemo.presentation

import android.app.Application
import com.vinodpatildev.mvvmdemo.BuildConfig
import com.vinodpatildev.mvvmdemo.presentation.di.Injector
import com.vinodpatildev.mvvmdemo.presentation.di.artist.ArtistSubComponent
import com.vinodpatildev.mvvmdemo.presentation.di.core.*
import com.vinodpatildev.mvvmdemo.presentation.di.movie.MovieSubComponent
import com.vinodpatildev.mvvmdemo.presentation.di.tvshow.TvShowSubComponent

class App: Application(), Injector {
    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .netModule(NetModule(BuildConfig.BASE_URL))
            .remoteDataModule(RemoteDataModule(BuildConfig.API_KEY))
            .build()

    }

    override fun createMovieSubComponent(): MovieSubComponent {
        return appComponent.movieSubComponent().create()
    }

    override fun createTvShowSubComponent(): TvShowSubComponent {
        return appComponent.tvShowSubComponent().create()
    }

    override fun createArtistSubComponent(): ArtistSubComponent {
        return appComponent.artistSubComponent().create()
    }
}