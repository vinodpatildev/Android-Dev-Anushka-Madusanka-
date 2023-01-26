package com.vinodpatildev.mvvmdemo.presentation.tvshow

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.vinodpatildev.mvvmdemo.R
import com.vinodpatildev.mvvmdemo.data.model.tvshow.TvShow
import com.vinodpatildev.mvvmdemo.databinding.ListItemBinding

class TvShowAdapter(): RecyclerView.Adapter<TvShowViewHolder>() {
    private val tvShowsList  = ArrayList<TvShow>()

    fun setTvShowList(tvShows:List<TvShow>){
        tvShowsList.clear()
        tvShowsList.addAll(tvShows)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val listItemBinding:ListItemBinding = DataBindingUtil.inflate(layoutInflater, R.layout.list_item, parent, false)
        return TvShowViewHolder(listItemBinding)
    }

    override fun onBindViewHolder(holder: TvShowViewHolder, position: Int) {
        holder.setTvShowViewHolder(tvShowsList[position])
    }

    override fun getItemCount(): Int {
        return tvShowsList.size
    }
}
class TvShowViewHolder(private val binding:ListItemBinding):RecyclerView.ViewHolder(binding.root){
    fun setTvShowViewHolder(tvShow: TvShow){
        binding.titleTextView.text = tvShow.name
        binding.descriptionTextView.text = tvShow.overview

        val posterUrl = "https://image.tmdb.org/t/p/w500" + tvShow.posterPath
        Glide.with(binding.imageView.context)
            .load(posterUrl)
            .into(binding.imageView)
    }
}