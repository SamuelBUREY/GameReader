package com.example.gamereader.Fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup

import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer

import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gamereader.Model.Game
import com.example.gamereader.R
import com.example.gamereader.view.GameAdapter
import com.example.gamereader.view.MainActivity
import com.example.gamereader.viewmodel.GamesVM


import kotlin.random.Random




class GamesFragment : Fragment() {

    private lateinit var  gameViewModel: GamesVM
    private  var  gameAdapter: GameAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        var view :View =inflater.inflate(R.layout.games_fragment_list,container,false)
        gameAdapter = this.context?.let { GameAdapter(it) }
        gameViewModel= ViewModelProviders.of(this).get(GamesVM::class.java)
        gameViewModel.allgames.observe(this, Observer { games ->
            games?.let {
                gameAdapter?.setData(it)
            }
        })
        var gamesRecycler : RecyclerView = view.findViewById(R.id.games_recycler)
        gamesRecycler.layoutManager = LinearLayoutManager(activity)
        gamesRecycler.adapter=  gameAdapter
        return view
    }



    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_delete -> {
                deleteGame()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }


    fun deleteGame() {
        listener?.deleteGame()
    }


    override fun onGameSelected(gameID: Long) {
        listener?.onGameSelected(gameID)
    }


    interface OnInteractionListener {
        fun onGameSelected(gameID: Long)
        fun deleteGame()
    }
    private var listener: OnInteractionListener? = null


    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnInteractionListener) {
            listener = context
        } else {
            throw RuntimeException("$context must implement OnInteractionListener")
        }
    }


    override fun onDetach() {
        super.onDetach()
        listener = null
    }


}