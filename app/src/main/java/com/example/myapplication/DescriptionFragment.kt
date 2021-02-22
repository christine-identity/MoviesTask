package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.myapplication.databinding.FragmentDescriptionBinding
import com.example.myapplication.databinding.FragmentMoviesListBinding

class DescriptionFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

       val binding = FragmentDescriptionBinding.inflate(inflater,container,false)


        val movieTitle = arguments?.getSerializable("title")
//        binding.overView.text = movie.toString()

       val movieOvervie = arguments?.getSerializable("overView")
        binding.overviewText.text = movieOvervie.toString()

        val releaseDate = arguments?.getSerializable("releaseDate")
       binding.date.text = releaseDate.toString()

        val movieImage = arguments?.getSerializable("imageURL")


        val imageView:ImageView=binding.movieImage2

        var imgUrl = "https://image.tmdb.org/t/p/w342${movieImage}"


            Glide.with(this)
                .load(imgUrl)
                .centerCrop()
                .into(imageView)





        return binding.root
    }

    companion object {

    }
}