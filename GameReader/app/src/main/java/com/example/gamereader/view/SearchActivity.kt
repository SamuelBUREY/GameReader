package com.example.gamereader.view


import android.app.SearchManager
import android.content.Context
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.Menu

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gamereader.BDD.GameRepository
import com.example.gamereader.R

import com.example.gamereader.model.Game
import com.example.gamereader.retrofit.ApiService
import com.example.gamereader.retrofit.RetrofitClient

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response



class SearchActivity : AppCompatActivity(),SearchView.OnQueryTextListener {

    private  var  gameAdapter: GameSearchAdapter? = null
    private lateinit var viewManager: RecyclerView.LayoutManager
    private var games : List<Game> = mutableListOf()
    lateinit var repository:GameRepository


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.search_activity)
        repository= GameRepository(application)
        viewManager = LinearLayoutManager(this)
        gameAdapter = GameSearchAdapter(applicationContext)
        gameAdapter?.setData(games)
        gameAdapter?.onItemClick = { game ->
            repository.insert(game)
        }
        var gamesRecycler : RecyclerView = findViewById(R.id.games_recycler_search)
        gamesRecycler.layoutManager = LinearLayoutManager(this)
        gamesRecycler.adapter=  gameAdapter

    }




    override fun onQueryTextChange(newText: String?): Boolean {
       return true
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
       request(query)
        return true
    }




    fun request(query: String?){
        var retrofit : RetrofitClient = RetrofitClient()
        val service = retrofit.getRetrofitInstance()?.create(ApiService::class.java)

        val body = "fields *; search "+"\""+query+"\""+";"

        val call = service?.getGameByID(body)


        val result = call?.enqueue(object : Callback<List<Game>> {
            override fun onFailure(call: Call<List<Game>>?, t: Throwable?) {
            }

            override fun onResponse(call: Call<List<Game>>?, response: Response<List<Game>>?) {
                var list :List<Game>
                list =response!!.body()
                gameAdapter?.setData(list)
            }
        })


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

}
