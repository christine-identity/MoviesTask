//package com.example.myapplication
//
//import ClickListener
//import android.content.res.Resources
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.ImageView
//import android.widget.TextView
//import android.widget.Toast
//import androidx.core.net.toUri
//import androidx.core.os.bundleOf
//import androidx.databinding.BindingAdapter
//import androidx.navigation.findNavController
//import androidx.recyclerview.widget.RecyclerView
//import com.bumptech.glide.Glide
//import com.bumptech.glide.load.resource.bitmap.CenterCrop
//import com.example.myapplication.MoviesListAdapter.MovieViewHolder.Companion.from
//
//class MoviesListAdapter(
//    private var movies: ArrayList<Result>,
//    private val clickListener: ClickListener
//) : RecyclerView.Adapter<MoviesListAdapter.MovieViewHolder>() {
//
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
//        return MovieViewHolder.from(parent)
//    }
//
//    override fun getItemCount(): Int = movies.size
//
//    override fun onBindViewHolder(
//        holder: MovieViewHolder,
//        position: Int
//    ) { //takes holder and position to bind
//        //  holder.bind(movies[position])
//        val item = movies[position];
//        holder.bind(item);
//
//    }
//
//    fun updateMovies(movies: List<Result>) {
//        this.movies.clear()
//        this.movies.addAll(movies)
//        notifyDataSetChanged()
//    }
//
//
//    inner class MovieViewHolder private constructor(itemView: View) :
//        RecyclerView.ViewHolder(itemView) {
//
//
//        val movieTitle: TextView = itemView.findViewById(R.id.movieTitle)
//        val releaseDate: TextView = itemView.findViewById(R.id.releaseDate)
//        val movieImage: ImageView = itemView.findViewById(R.id.movieImage)
//
//        fun bind(movie: Result) {
//            var imgUrl = "https://image.tmdb.org/t/p/w342${movie.posterPath}"
//
//            movieTitle.text = movie.title;
//            releaseDate.text = movie.releaseDate;
//            Glide.with(itemView)
//                .load(imgUrl)
//                .centerCrop()
//                .into(movieImage)
//
//
//        }
//
//        inner companion object {
//            fun from(parent: ViewGroup): MovieViewHolder {
//                val view = LayoutInflater
//                    .from(parent.context)
//                    .inflate(R.layout.text_item_view, parent, false)
//                return MovieViewHolder(view)
//            }
//        }
//
//
//    }
//}
////  init{
////             itemView.setOnClickListener { v:View ->
////                 val position=adapterPosition
////                 Toast.makeText(itemView.context,"you clicked ${position+1}",Toast.LENGTH_SHORT).show()
////             }
////             val bundle = bundleOf("id" to adapterPosition+1)
////             itemView.setOnClickListener { view: View ->
////                 clickListener.onClick(adapterPosition)
////                 val result = movies[adapterPosition]
////                 view.findNavController().navigate(R.id.action_moviesListFragment_to_descriptionFragment,bundle)
//
//// }
////class MovieListener(val clickListener: (movieId: Long) -> Unit) {
////    fun onClick(movie: Result) = clickListener(movie.id.toLong())
////}
//
