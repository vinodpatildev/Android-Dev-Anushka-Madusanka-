package com.vinodpatildev.mvvmdemo.presentation.di

import com.vinodpatildev.mvvmdemo.presentation.di.artist.ArtistSubComponent
import com.vinodpatildev.mvvmdemo.presentation.di.movie.MovieSubComponent
import com.vinodpatildev.mvvmdemo.presentation.di.tvshow.TvShowSubComponent

interface Injector {
   fun createMovieSubComponent(): MovieSubComponent
   fun createTvShowSubComponent(): TvShowSubComponent
   fun createArtistSubComponent(): ArtistSubComponent
}