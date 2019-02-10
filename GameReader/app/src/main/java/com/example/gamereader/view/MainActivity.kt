package com.example.gamereader.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.example.gamereader.R
import com.example.gamereader.viewmodel.GamesVM
import kotlinx.android.synthetic.main.activity_main.*
import androidx.lifecycle.ViewModelProviders
import com.example.gamereader.Model.Game
import androidx.recyclerview.widget.LinearLayoutManager

import androidx.recyclerview.widget.RecyclerView
import com.example.gamereader.Fragment.GamesFragment
import kotlin.random.Random


 class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar_Main))
        supportActionBar?.setIcon(R.mipmap.ic_launcher)
        if(supportFragmentManager.findFragmentById(R.id.fragment_container)==null){
            supportFragmentManager.beginTransaction()
                    .add(R.id.fragment_container, GamesFragment()).commit()
        }
    }


}
