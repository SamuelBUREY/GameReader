package com.example.gamereader.view

import android.content.Intent
import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.AppBarConfiguration

import androidx.navigation.ui.setupWithNavController
import com.example.gamereader.R

import com.example.gamereader.fragment.GamesFragment
import com.example.gamereader.fragment.GamesFragmentDirections
import kotlinx.android.synthetic.main.activity_main.*

import android.content.Context


class MainActivity : AppCompatActivity(),GamesFragment.OnInteractionListener {





    private lateinit var navigator: NavController


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.gamereader.R.layout.activity_main)
        setSupportActionBar(toolbar_Main)
        navigator = Navigation.findNavController(this,R.id.navigator)
        toolbar_Main.setupWithNavController(navigator, AppBarConfiguration(navigator.graph))



    }

     override fun onGameSelected(gameID: Long) {
         val action = GamesFragmentDirections.actionGamesFragmentToGameDetailFragment(gameID)
         navigator.navigate(action)
    }

    override fun researchGame() {
        val intent = Intent(applicationContext, SearchActivity::class.java)
        startActivity(intent)

    }





}
