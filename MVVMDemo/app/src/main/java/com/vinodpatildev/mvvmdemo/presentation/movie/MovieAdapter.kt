package com.vinodpatildev.mvvmdemo.presentation.movie

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.vinodpatildev.mvvmdemo.R
import com.vinodpatildev.mvvmdemo.data.model.movie.Movie
import com.vinodpatildev.mvvmdemo.databinding.ListItemBinding

class MovieAdapter(): RecyclerView.Adapter<MovieViewHolder>() {
    private val movieList = ArrayList<Movie>()
    fun setMovieList(movies:List<Movie>){
        movieList.clear()
        movieList.addAll(movies)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val listItemBinding:ListItemBinding = DataBindingUtil.inflate(layoutInflater, R.layout.list_item, parent, false)
        return MovieViewHolder(listItemBinding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.setMovieViewHolder(movieList[position])
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

}
class MovieViewHolder(private val binding:ListItemBinding): RecyclerView.ViewHolder(binding.root){
    fun setMovieViewHolder(movie:Movie){
        binding.titleTextView.text = movie.title
        binding.descriptionTextView.text = movie.overview

        val posterUrl = "https://image.tmdb.org/t/p/w500"+movie.posterPath
        Glide.with(binding.imageView.context)
            .load(posterUrl)
            .into(binding.imageView)
    }
}