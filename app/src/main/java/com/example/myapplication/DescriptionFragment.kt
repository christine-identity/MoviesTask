package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
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


       val movie = arguments?.getBundle("id")
        binding.overView.text = movie.toString()
        Toast.makeText(this.context,"you clicked ${movie}",Toast.LENGTH_SHORT).show()

        return binding.root
    }

    companion object {

    }
}