package gam.trainingcourse.navigationdrawer.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import gam.trainingcourse.navigationdrawer.databinding.ItemGenreBinding
import gam.trainingcourse.navigationdrawer.model.Genre

class GenreAdapter(private val genres: MutableList<Genre>) :
    RecyclerView.Adapter<GenreAdapter.GenreViewHolder>() {

    inner class GenreViewHolder(val binding: ItemGenreBinding) :
        RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenreViewHolder {
        val binding = ItemGenreBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GenreViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GenreViewHolder, position: Int) {
        holder.binding.genre = genres[position]
    }

    override fun getItemCount(): Int = genres.size
}