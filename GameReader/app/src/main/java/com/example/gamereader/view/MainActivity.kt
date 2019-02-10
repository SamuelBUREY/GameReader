package com.example.gamereader.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.gamereader.R

import com.example.gamereader.Fragment.GameDetailFragment
import com.example.gamereader.Fragment.GamesFragment


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


     fun fragmentDetailCall(id:Long){
         Log.d("idgameActivity",id.toString())
         val nextFrag = GameDetailFragment.newInstance(id)
         supportFragmentManager.beginTransaction()
             .replace(R.id.fragment_container, nextFrag, "findThisFragment")
             .addToBackStack(null)
             .commit()
     }


}
