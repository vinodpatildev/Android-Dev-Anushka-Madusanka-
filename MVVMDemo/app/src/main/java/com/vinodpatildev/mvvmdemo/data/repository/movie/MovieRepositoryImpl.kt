package com.vinodpatildev.mvvmdemo.data.repository.movie

import android.util.Log
import com.vinodpatildev.mvvmdemo.data.model.movie.Movie
import com.vinodpatildev.mvvmdemo.data.repository.movie.datasource.MovieCacheDataSource
import com.vinodpatildev.mvvmdemo.data.repository.movie.datasource.MovieLocalDataSource
import com.vinodpatildev.mvvmdemo.data.repository.movie.datasource.MovieRemoteDataSource
import com.vinodpatildev.mvvmdemo.domain.repository.MovieRepository

class MovieRepositoryImpl(
    private val movieRemoteDataSource: MovieRemoteDataSource,
    private val movieLocalDataSource: MovieLocalDataSource,
    private val movieCacheDataSource: MovieCacheDataSource
):MovieRepository {
    override suspend fun getMovies(): List<Movie>? {
        return getMoviesFromCaches()
    }

    override suspend fun updateMovies(): List<Movie>? {
        var newMovieList = getMoviesFromAPI()
        movieLocalDataSource.clearAll()
        movieLocalDataSource.saveMoviesToDB(newMovieList)
        movieCacheDataSource.saveMoviesToCache(newMovieList)
        return newMovieList
    }

    suspend fun getMoviesFromAPI():List<Movie>{
        lateinit var movieList : List<Movie>
        try {
            var response = movieRemoteDataSource.getMovies()
            var body = response.body()
            if(body != null){
                movieList = body.movies
            }
        } catch (exception : Exception){
            Log.i("fuck_mylog_1",exception.message.toString())
        }
        return movieList
    }
    suspend fun getMoviesFromDB():List<Movie>{
        lateinit var movieList:List<Movie>
        try {
            movieList = movieLocalDataSource.getMoviesFromDB()
        }catch (exception :Exception){
            Log.i("fuck_mylog_2",exception.message.toString())
        }
        if(movieList.size<=0){
            movieList = getMoviesFromAPI()
            movieLocalDataSource.saveMoviesToDB(movieList)
        }
        return movieList
    }
    suspend fun getMoviesFromCaches():List<Movie>{
        lateinit var movieList:List<Movie>
        try {
            movieList = movieCacheDataSource.getMoviesFromCache()
        }catch (exception :Exception){
            Log.i("fuck_mylog_3",exception.message.toString())
        }
        if(movieList.size<=0){
            movieList = getMoviesFromDB()
            movieCacheDataSource.saveMoviesToCache(movieList)
        }
        return movieList
    }
}