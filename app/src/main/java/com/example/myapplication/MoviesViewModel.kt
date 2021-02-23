package com.example.myapplication

import ClickListener
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.navigation.fragment.findNavController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.io.Serializable
import java.util.*
import kotlin.collections.ArrayList


class MoviesViewModel: ViewModel() {
    val moviesObject = MutableLiveData<List<Result>>()
    private var viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main +  viewModelJob)

    init {
     Log.d("hi","viewModel created")
        initializeMovies()
        //getAPIResult()

 }
    private fun initializeMovies() {
        //defining a scope and launching a coroutine
        uiScope.launch {
            getAPIResult()
            Log.d("coroutine","created")
            LogThread("initializeMovies")
        }
    }
    private suspend fun getAPIResult(){

        MoviesObject.getPopularMovies(
            onSuccess = ::onPopularMoviesFetched,
            onError = ::onError
        )
    }

    private fun onPopularMoviesFetched(movies: List<Result>) {
        Log.d("MainActivity", "Movies: ${movies}")
        this.moviesObject.value = movies

    }

    private fun onError() {
        Log.d("MainActivity", "failed again")
    }
    override fun onCleared() {
        super.onCleared()
        Log.d("","cleared")
        viewModelJob.cancel()
    }
    fun LogThread(methodName:String){
        Log.d("debug" +{methodName},"Thread:"+{Thread.currentThread().name})
    }
}