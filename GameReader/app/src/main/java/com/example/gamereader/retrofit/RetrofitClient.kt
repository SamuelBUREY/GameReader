package com.example.gamereader.retrofit

import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit



class RetrofitClient {

     var retrofit: Retrofit? = null
     val BASE_URL = "https://api-v3.igdb.com\n"

    fun getRetrofitInstance(): Retrofit? {
        if (retrofit == null) {
            retrofit = retrofit2.Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit
    }
}

