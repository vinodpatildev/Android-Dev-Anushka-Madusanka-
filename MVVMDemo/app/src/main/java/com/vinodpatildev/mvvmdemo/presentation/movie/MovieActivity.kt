package com.vinodpatildev.mvvmdemo.presentation.movie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.vinodpatildev.mvvmdemo.R
import com.vinodpatildev.mvvmdemo.databinding.ActivityMovieBinding
import com.vinodpatildev.mvvmdemo.presentation.di.Injector
import javax.inject.Inject

class MovieActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMovieBinding
    @Inject
    lateinit var factory:MovieViewModelFactory
    private lateinit var movieViewModel: MovieViewModel
    private lateinit var movie_adapter: MovieAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_movie)
        (application as Injector).createMovieSubComponent().inject(this)
        movieViewModel = ViewModelProvider(this, factory).get(MovieViewModel::class.java)

        initMovieRecyclerView()
    }

    private fun initMovieRecyclerView() {
        binding.movieRecyclerView.layoutManager = LinearLayoutManager(this)
        movie_adapter = MovieAdapter()
        binding.movieRecyclerView.adapter = movie_adapter
        displayMoviesInRecyclerView()
    }

    private fun displayMoviesInRecyclerView() {
        val responseLiveData = movieViewModel.getMovies()
        binding.movieProgressBar.visibility = View.VISIBLE
        responseLiveData.observe(this, Observer {movies->
            if(movies != null){
                binding.movieProgressBar.visibility = View.GONE
                movie_adapter.setMovieList(movies!!)
                movie_adapter.notifyDataSetChanged()
            }else{
                Snackbar.make(binding.root,"No movies found.",Snackbar.LENGTH_LONG).show()
            }
        })
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.update, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.action_update ->{
                updateMovies()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun updateMovies(){
        binding.movieProgressBar.visibility = View.VISIBLE
        val response = movieViewModel.updateMovies()
        response.observe(this, Observer{
            if(it!=null){
                binding.movieProgressBar.visibility = View.GONE
                movie_adapter.setMovieList(it)
                movie_adapter.notifyDataSetChanged()
            }else{
                Snackbar.make(binding.root, "No movies found.", Snackbar.LENGTH_LONG).show()
            }
        })
    }

}
