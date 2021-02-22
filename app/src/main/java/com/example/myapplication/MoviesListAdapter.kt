package com.example.myapplication

import ClickListener
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class MoviesListAdapter(
    private var movies: ArrayList<Result>,
    private val clickListener: ClickListener
) : RecyclerView.Adapter<MoviesListAdapter.MovieViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder.from(parent)
    }

    override fun getItemCount(): Int = movies.size

    override fun onBindViewHolder(
        holder: MovieViewHolder,
        position: Int
    ) { //takes holder and position to bind
        //  holder.bind(movies[position])
        val item = movies[position];
        holder.bind(item);
        holder.movieTitle.setOnClickListener {
            clickListener.onClick(position)
            Log.d("MainActivity", "failed againxxxxxxxxxxxxxxx ${position}")
        }
    }

    fun updateMovies(movies: List<Result>) {
        this.movies.clear()
        this.movies.addAll(movies)
        notifyDataSetChanged()
    }


    class MovieViewHolder private constructor(itemView: View) :
        RecyclerView.ViewHolder(itemView) {


        val movieTitle: TextView = itemView.findViewById(R.id.movieTitle)
        val releaseDate: TextView = itemView.findViewById(R.id.releseDate)
        val movieImage: ImageView = itemView.findViewById(R.id.movieImage)

        fun bind(movie: Result) {
            var imgUrl = "https://image.tmdb.org/t/p/w342${movie.posterPath}"

            movieTitle.text = movie.title;
            releaseDate.text = movie.releaseDate;
            Glide.with(itemView)
                .load(imgUrl)
                .centerCrop()
                .into(movieImage)


        }

          companion object {
            fun from(parent: ViewGroup): MovieViewHolder {
                val view = LayoutInflater
                    .from(parent.context)
                    .inflate(R.layout.text_item_view, parent, false)
                return MovieViewHolder(view)
            }
        }


    }
}

