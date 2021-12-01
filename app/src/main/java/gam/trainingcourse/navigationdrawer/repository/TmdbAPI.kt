package gam.trainingcourse.navigationdrawer.repository

import gam.trainingcourse.navigationdrawer.model.Movies
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.Call
interface TmdbAPI {

    @GET("/3/movie/popular")
    fun getPopularMovies(@Query("api_key") key: String): Call<Movies>

    @GET("/3/movie/top_rated")
    fun getTopRatedMovies(@Query("api_key") key: String): Call<Movies>
}