package gam.trainingcourse.navigationdrawer.viewmodel

import android.annotation.SuppressLint
import android.content.Context

import android.widget.Toast

import androidx.lifecycle.ViewModel
import gam.trainingcourse.navigationdrawer.R
import gam.trainingcourse.navigationdrawer.adapter.MovieAdapter
import gam.trainingcourse.navigationdrawer.model.Genre
import gam.trainingcourse.navigationdrawer.model.Movie
import gam.trainingcourse.navigationdrawer.model.Movies
import gam.trainingcourse.navigationdrawer.repository.API
import gam.trainingcourse.navigationdrawer.repository.TmdbAPI
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ForYouViewModel : ViewModel() {
    private val request = API.buildService(TmdbAPI::class.java)

    val popularMovies = mutableListOf<Movie>()
    val topRatedMovies = mutableListOf<Movie>()

    val genres = mutableListOf<Genre>()

    fun initPopularMovie(context: Context, popularMoviesAdapter: MovieAdapter){
        val call1 = request.getPopularMovies(context.getString(R.string.api_key))
        call1.enqueue(object : Callback<Movies> {
            @SuppressLint("NotifyDataSetChanged")
            override fun onResponse(call: Call<Movies>, response: Response<Movies>) {
                if (response.isSuccessful) {
                    response.body()?.let { popularMovies.addAll(it.results) }
                    popularMoviesAdapter.notifyDataSetChanged()
                }
            }

            override fun onFailure(call: Call<Movies>, t: Throwable) {
                Toast.makeText(context, "${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }
    fun initTopRatedMovie(context: Context, topRatedMoviesAdapter: MovieAdapter){
        val call2 = request.getTopRatedMovies(context.getString(R.string.api_key))
        call2.enqueue(object : Callback<Movies> {
            @SuppressLint("NotifyDataSetChanged")
            override fun onResponse(call: Call<Movies>, response: Response<Movies>) {
                if (response.isSuccessful) {
                    response.body()?.let { topRatedMovies.addAll(it.results) }
                    topRatedMoviesAdapter.notifyDataSetChanged()
                }
            }

            override fun onFailure(call: Call<Movies>, t: Throwable) {
                Toast.makeText(context, "${t.message}", Toast.LENGTH_SHORT).show()
            }

        })
    }

    fun initGenres(context: Context){
        val genreName = context.resources.getStringArray(R.array.genres)
        val genreUrl = context.resources.getStringArray(R.array.genreUrl)
        for (i in genreName.indices)
            genres.add(Genre(genreUrl[i], genreName[i]))
    }

}