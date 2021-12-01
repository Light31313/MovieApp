package gam.trainingcourse.navigationdrawer.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import gam.trainingcourse.navigationdrawer.databinding.ItemMovieBinding
import gam.trainingcourse.navigationdrawer.model.Movie

class MovieAdapter(val context: Context, private val movies: MutableList<Movie>) :
    RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    inner class MovieViewHolder(val binding: ItemMovieBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val binding = ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.binding.movie = movies[position]
    }


    override fun getItemCount(): Int = movies.size
}