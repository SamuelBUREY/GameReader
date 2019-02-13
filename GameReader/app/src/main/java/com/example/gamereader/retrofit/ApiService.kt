package com.example.gamereader.retrofit

import android.telecom.Call
import retrofit2.http.GET



interface ApiService
{
    @GET("/games")
    fun getAllGame(): Call
}