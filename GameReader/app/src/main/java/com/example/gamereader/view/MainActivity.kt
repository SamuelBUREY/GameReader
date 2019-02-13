package com.example.gamereader.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.example.gamereader.R

import com.example.gamereader.Fragment.GameDetailFragment
import com.example.gamereader.Fragment.GamesFragment
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private lateinit var navigator: NavController


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar_Main)
        navigator = Navigation.findNavController(this,R.id.navigator)
        toolbar_Main.setupWithNavController(navigator, AppBarConfiguration(navigator.graph))

    }


}
