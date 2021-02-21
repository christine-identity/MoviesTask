package com.example.myapplication

import ClickListener
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.FragmentMoviesListBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MoviesListFragment : Fragment() {


   var adapter: MoviesListAdapter = MoviesListAdapter(ArrayList(), object : ClickListener {
       override fun onClick(pos: Int) {

           val result = moviesObject[pos]
           val id=pos;
           val bundle = bundleOf("id" to id)
           Log.d("fragment xxxxxxxxxxxxxx", "gggg${id}")
           findNavController().navigate(R.id.action_moviesListFragment_to_descriptionFragment,bundle)//moshkla fel bundle

       }
   })
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentMoviesListBinding.inflate(inflater,container,false)
//        binding.movieTitle.setOnClickListener { view: View ->
//            view.findNavController().navigate(R.id.action_moviesListFragment_to_descriptionFragment)
//
//
//        }
        MoviesObject.getPopularMovies(
                onSuccess = ::onPopularMoviesFetched,
                onError = ::onError)

        binding.moviesList.adapter=adapter;


        return binding.root
    }


    private val moviesObject = ArrayList<Result>()
    private fun onPopularMoviesFetched(movies: List<Result>) {
        Log.d("MainActivity", "Movies: ${movies}")
        this.moviesObject.addAll(movies)
        adapter.updateMovies(movies)
    }

    private fun onError() {
        Log.d("MainActivity", "failed again")
    }
}