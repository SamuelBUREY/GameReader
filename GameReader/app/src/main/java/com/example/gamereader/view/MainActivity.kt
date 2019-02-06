package com.example.gamereader.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.gamereader.R
import com.example.gamereader.viewmodel.GamesVM
import kotlinx.android.synthetic.main.activity_main.*
import androidx.lifecycle.ViewModelProviders
import com.example.gamereader.Model.Game
import androidx.recyclerview.widget.LinearLayoutManager

import androidx.recyclerview.widget.RecyclerView
import kotlin.random.Random


class MainActivity : AppCompatActivity() {


    private lateinit var  gameAdapter: GameAdapter
    private lateinit var  gameViewModel: GamesVM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        gameViewModel = ViewModelProviders.of(this).get(GamesVM::class.java)

        game_Add_Button.setOnClickListener{
               gameViewModel.insert(Game(Random.nextLong(),"GTA","Ceci est un jeu de voiture en ligne ou en solo","XBOX, PS4","voiture ,action"))
        }
        gameAdapter = GameAdapter(this)


        var recylerview : RecyclerView = findViewById(R.id.my_recycler_games)
        recylerview.layoutManager=LinearLayoutManager(this)
        recylerview.adapter=gameAdapter

        gameViewModel.allgames.observe(this, Observer { games ->
            games?.let { gameAdapter.setData(it) }
        })



    }


}
