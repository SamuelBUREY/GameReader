package com.example.gamereader.view

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.ViewModelProviders
import com.example.gamereader.R
import com.example.gamereader.model.Game
import com.example.gamereader.retrofit.ApiService
import com.example.gamereader.retrofit.RetrofitClient
import com.example.gamereader.viewmodel.GamesVM
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.Body


class SearchActivity : AppCompatActivity(),SearchView.OnQueryTextListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.search_activity)


    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.options_menu, menu)

        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        (menu.findItem(R.id.search).actionView as SearchView).apply {
            setSearchableInfo(searchManager.getSearchableInfo(componentName))

        }
        var searchMenuItem = menu.findItem(R.id.search)
        var searchview :SearchView= searchMenuItem.actionView as SearchView
        searchview.setOnQueryTextListener(this)
        searchview.isSubmitButtonEnabled=true
        return true

    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        Log.d("TESTAPI","test passage")
       request()
        return true
    }


    override fun onQueryTextChange(newText: String?): Boolean {
        return false
    }


    fun request(){
        var retrofit : RetrofitClient = RetrofitClient()
        val service = retrofit.getRetrofitInstance()?.create(ApiService::class.java)

        val body = "fields *; \"Halo\";"
        Log.d("TESTAPI",body)

        val call = service?.getGameByID(body)


        val result = call?.enqueue(object : Callback<List<Game>> {
            override fun onFailure(call: Call<List<Game>>?, t: Throwable?) {
                Log.v("retrofit", "call failed")
            }

            override fun onResponse(call: Call<List<Game>>?, response: Response<List<Game>>?) {
                var list :List<Game>
                list =response!!.body()
                var  gameViewModel = GamesVM(application)
                Log.d("SIZELIST",list.size.toString())
                for(game: Game in list){
                    gameViewModel.insert(game)
                }
            }

        })
        Log.d("TESTAPI","value"+result)

    }

}
