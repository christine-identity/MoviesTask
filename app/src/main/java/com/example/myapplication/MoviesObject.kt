package com.example.myapplication

import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MoviesObject {

    private val api: API

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        api = retrofit.create(API::class.java)
    }

    fun getPopularMovies(page: Int = 1,onSuccess: (movies: List<Result>) -> Unit,onError: () -> Unit) {
        api.getPopularMovies(page = page)
            .enqueue(object : Callback<Movies> {
                override fun onResponse(
                    call: Call<Movies>,
                    response: Response<Movies>
                ) {
                    if (response.isSuccessful) {
                        val responseBody = response.body()

                        if (responseBody != null) {
                            onSuccess.invoke(responseBody.movies)
                        } else {
                            onError.invoke()
                        }
                    } else {
                        onError.invoke()
                    }
                }

                override fun onFailure(call: Call<Movies>, t: Throwable) {
                    onError.invoke()
                }
            })
    }
}