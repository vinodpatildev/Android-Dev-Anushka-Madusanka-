package com.vinodpatildev.mvvmdemo.data.model.tvshow
import com.google.gson.annotations.SerializedName
import com.vinodpatildev.mvvmdemo.data.model.tvshow.TvShow

data class TvShowList(
    @SerializedName("results")
    val tvShows: List<TvShow>,
)