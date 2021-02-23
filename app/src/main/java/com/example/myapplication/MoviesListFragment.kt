package com.example.myapplication

import ClickListener
import android.app.ActionBar
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import com.example.myapplication.databinding.FragmentMoviesListBinding


class MoviesListFragment : Fragment() {

private lateinit var viewModel:MoviesViewModel

    var adapter: MoviesListAdapter = MoviesListAdapter(ArrayList(), object : ClickListener {

        override fun onClick(pos: Int) {

            val bundle = Bundle()

//           bundle.putSerializable(MoviesListFragment.RESULT, moviesObject[pos])
            viewModel.moviesObject.observe(viewLifecycleOwner, Observer { object1->

                val bundle = Bundle()
                bundle.putSerializable(MoviesListFragment.RESULT, object1[pos])
              nav(bundle)
            })

        }
    })
    fun nav(bundle:Bundle){
        findNavController().navigate(
            R.id.action_moviesListFragment_to_descriptionFragment,
            bundle
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentMoviesListBinding.inflate(inflater, container, false)

        (activity as AppCompatActivity?)!!.supportActionBar!!.title = "Popular Movies"
//        viewModel = ViewModelProviders.of(this).get(MoviesViewModel::class.java)
        Log.i("hiii","view model is called")
       // viewModel = ViewModelProvider(this).get(MoviesViewModel::class.java)
        viewModel = ViewModelProviders.of(this).get(MoviesViewModel::class.java)
// Corutine
//        MoviesObject.getPopularMovies(
//            onSuccess = ::onPopularMoviesFetched,
//            onError = ::onError
//        )

        binding.moviesList.adapter = adapter;
        viewModel.moviesObject.observe(viewLifecycleOwner, Observer { movies->
            adapter.updateMovies(movies)
        })



        return binding.root
    }


//    private val moviesObject = ArrayList<Result>()
//    private fun onPopularMoviesFetched(movies: List<Result>) {
//        Log.d("MainActivity", "Movies: ${movies}")
//        this.moviesObject.addAll(movies)
//        adapter.updateMovies(movies)
//    }
//
//    private fun onError() {
//        Log.d("MainActivity", "failed again")
//    }

    companion object {
        const val RESULT = "RESULT"
    }
}