package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.toColor
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.myapplication.databinding.FragmentDescriptionBinding


class DescriptionFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

       val binding = FragmentDescriptionBinding.inflate(inflater,container,false)



        val movieImage = arguments?.getSerializable("imageURL")
        val imageView:ImageView=binding.movieImage2
        var imgUrl = "https://image.tmdb.org/t/p/w342${movieImage}"


        Glide.with(this)
            .load(imgUrl)
            .centerCrop()
            .into(imageView)

        val movieTitle = arguments?.getSerializable("title")
        (activity as AppCompatActivity?)!!.supportActionBar!!.title = movieTitle?.toString()


       val movieOvervie = arguments?.getSerializable("overView")
        binding.overviewText.text = movieOvervie.toString()

        val releaseDate = arguments?.getSerializable("releaseDate")
       binding.date.text = releaseDate.toString()









        return binding.root
    }

    companion object {

    }
}