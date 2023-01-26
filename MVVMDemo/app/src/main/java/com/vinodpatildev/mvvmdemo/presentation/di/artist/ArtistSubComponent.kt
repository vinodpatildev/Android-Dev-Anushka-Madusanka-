package com.vinodpatildev.mvvmdemo.presentation.di.artist

import com.vinodpatildev.mvvmdemo.presentation.artist.ArtistActivity
import dagger.Subcomponent


@ArtistScope
@Subcomponent(modules = [ArtistModule::class])
interface ArtistSubComponent {
    fun inject(artistActivity: ArtistActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create():ArtistSubComponent
    }
}

