package com.vinodpatildev.mvvmdemo.presentation.artist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.vinodpatildev.mvvmdemo.domain.usecases.GetArtistUseCase
import com.vinodpatildev.mvvmdemo.domain.usecases.UpdateArtistUseCase

class ArtistViewModelFactory(
    private val getArtistUseCase: GetArtistUseCase,
    private val updateArtistUseCase: UpdateArtistUseCase
): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//        return super.create(modelClass)
        return ArtistViewModel(getArtistUseCase,updateArtistUseCase) as T
    }
}