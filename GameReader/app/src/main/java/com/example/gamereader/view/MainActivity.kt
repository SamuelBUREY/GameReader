package com.example.gamereader.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.gamereader.R
import com.example.gamereader.viewmodel.GamesVM
import kotlinx.android.synthetic.main.activity_main.*
import androidx.lifecycle.ViewModelProviders
import com.example.gamereader.Model.Game
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager

import androidx.recyclerview.widget.RecyclerView








class MainActivity : AppCompatActivity() {


    private val gameAdapter: GameAdapter? = null
    private val gameViewModel: GamesVM? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        game_Add_Button.setOnClickListener{
               gameViewModel.insert(Game(10,"GTA","voiture","XBOX, PS4","voiture ,action"))
        }

        gameAdapter = GameAdapter(this)

        gameViewModel = ViewModelProviders.of(this).get(GamesVM::class.java!!)
        gameViewModel.getAllGames().observe(this, { games -> gameAdapter.setData(games) })

        val recyclerView = findViewById(R.id.game_)
        recyclerView.setLayoutManager(LinearLayoutManager(this))
        recyclerView.setHasFixedSize(true)
        recyclerView.setItemAnimator(DefaultItemAnimator())
        recyclerView.setAdapter(gameAdapter)



    }


}
