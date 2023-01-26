package com.vinodpatildev.mvvmdemo.presentation.di.artist

import com.vinodpatildev.mvvmdemo.domain.usecases.GetArtistUseCase
import com.vinodpatildev.mvvmdemo.domain.usecases.UpdateArtistUseCase
import com.vinodpatildev.mvvmdemo.presentation.artist.ArtistViewModelFactory
import dagger.Module
import dagger.Provides


@Module
class ArtistModule {
    @ArtistScope
    @Provides
    fun provideArtistViewModelFactory(
        getArtistsUseCase: GetArtistUseCase,
        updateArtistsUseCase: UpdateArtistUseCase
    ): ArtistViewModelFactory {
        return ArtistViewModelFactory(
            getArtistsUseCase,
            updateArtistsUseCase
        )
    }

}