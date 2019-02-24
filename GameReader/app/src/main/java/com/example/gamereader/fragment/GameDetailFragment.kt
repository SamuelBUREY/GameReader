package com.example.gamereader.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.gamereader.R
import com.example.gamereader.model.Game
import com.example.gamereader.retrofit.ApiService
import com.example.gamereader.retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GameDetailFragment : Fragment(){


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view : View =inflater.inflate(R.layout.game_detail,container,false)
        return view
    }





    fun request(){
        var retrofit :RetrofitClient = RetrofitClient()
        val service = retrofit.getRetrofitInstance()?.create(ApiService::class.java)

        val request = service?.getGameByID()
        request?.enqueue(object : Callback<List<Game>> {
            override fun onResponse(call: Call<List<Game>>, response: Response<List<Game>>) {
                val allgame = response.body()
                if (allgame != null) {

                    for (c in allgame)
                        Log.d("game",c.name)
                }
            }
            override fun onFailure(call: Call<List<Game>>, t: Throwable) {
                error("Error Request")
            }
        })
    }


}