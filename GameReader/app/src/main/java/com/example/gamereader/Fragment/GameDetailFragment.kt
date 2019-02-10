package com.example.gamereader.Fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gamereader.Model.Game
import com.example.gamereader.R
import com.example.gamereader.view.GameAdapter
import com.example.gamereader.viewmodel.GamesVM
import kotlin.random.Random

class GameDetailFragment : Fragment(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        var view : View =inflater.inflate(R.layout.game_detail,container,false)
        return view
    }


}