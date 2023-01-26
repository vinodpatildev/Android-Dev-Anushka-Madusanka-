package com.vinodpatildev.mvvmdemo.presentation.artist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.vinodpatildev.mvvmdemo.R
import com.vinodpatildev.mvvmdemo.data.model.artist.Artist
import com.vinodpatildev.mvvmdemo.databinding.ListItemBinding

class ArtistAdapter(): RecyclerView.Adapter<ArtistViewHolder>() {
    private val artistList = ArrayList<Artist>()

    fun setArtistList(artists:List<Artist>){
        artistList.clear()
        artistList.addAll(artists)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtistViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val listItemBinding:ListItemBinding = DataBindingUtil.inflate(layoutInflater, R.layout.list_item, parent, false)
        return ArtistViewHolder(listItemBinding)
    }

    override fun onBindViewHolder(holder: ArtistViewHolder, position: Int) {
        holder.setArtistViewHolder(artistList[position])
    }

    override fun getItemCount(): Int {
        return artistList.size
    }
}
class ArtistViewHolder(private val binding:ListItemBinding):RecyclerView.ViewHolder(binding.root){
    fun setArtistViewHolder(artist: Artist){
        binding.titleTextView.text = artist.name
        binding.descriptionTextView.text = artist.popularity.toString()
        val posterPath = "https://image.tmdb.org/t/p/w500" + artist.profilePath
        Glide.with(binding.imageView.context)
            .load(posterPath)
            .into(binding.imageView)
    }

}