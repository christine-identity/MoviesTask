package com.example.myapplication

import android.graphics.Color
import android.graphics.Color.red
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.toColor
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.myapplication.databinding.FragmentDescriptionBinding


class DescriptionFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

       val binding = FragmentDescriptionBinding.inflate(inflater,container,false)

        val res = arguments?.getSerializable(MoviesListFragment.RESULT) as Result
        Log.d("res", "r : "+ res.title)

        //val movieImage = arguments?.getSerializable("imageURL")
        val imageView:ImageView=binding.movieImage2
        var imgUrl = "https://image.tmdb.org/t/p/w342${res.posterPath}"


        Glide.with(this)
            .load(imgUrl)
            .centerCrop()
            .into(imageView)

        //val movieTitle = arguments?.getSerializable("title")
        (activity as AppCompatActivity?)!!.supportActionBar!!.title = res.title?.toString()



        //val movieOvervie = arguments?.getSerializable("overView")
        binding.overviewText.text = res.overview.toString()

       // val releaseDate = arguments?.getSerializable("releaseDate")
       binding.date.text = res.releaseDate.toString()


        return binding.root
    }
    // this event will enable the back
    // function to the button on press
    override fun onContextItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                //finish()
                return true
            }
        }
        return super.onContextItemSelected(item)
    }

    companion object {

    }
}