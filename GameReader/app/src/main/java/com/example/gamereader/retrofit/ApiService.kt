package com.example.gamereader.retrofit

import com.example.gamereader.model.Game
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers

import retrofit2.http.POST


interface ApiService
{
    @Headers("user-key: 1514ec7964e14cf09b6edba7a67ce37d")
    @POST("/games")
    fun getGameByID(@Body  body: String): Call<List<Game>>
}