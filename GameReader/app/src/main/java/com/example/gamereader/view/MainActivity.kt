package com.example.gamereader.view

import android.os.Bundle
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity;
import android.view.Menu
import android.view.MenuItem
import androidx.room.Room
import com.example.gamereader.BDD.GamesDataBase
import com.example.gamereader.R
import com.example.gamereader.viewmodel.GamesVM

import kotlinx.android.synthetic.main.activity_main.*
import androidx.lifecycle.ViewModelProviders



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val gamesVM = ViewModelProviders.of(this).get(GamesVM::class.java!!)


    }


     fun addgame(){

     }


}
