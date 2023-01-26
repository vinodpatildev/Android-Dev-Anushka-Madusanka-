package com.vinodpatildev.mvvmdemo.data.model.artist


import com.google.gson.annotations.SerializedName
import com.vinodpatildev.mvvmdemo.data.model.artist.Artist

data class ArtistList(
    @SerializedName("results")
    val artists: List<Artist>
)