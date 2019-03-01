package com.example.gamereader.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.gamereader.BDD.GameRepository
import com.example.gamereader.R
import com.example.gamereader.model.Game
import kotlinx.android.synthetic.main.game_detail.*


class GameDetailFragment : Fragment() {

    var gameId: Long = 0
    val args: GameDetailFragmentArgs by navArgs()
    lateinit var game:Game
    lateinit var repository:GameRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        gameId=args.gameID
        repository = GameRepository(activity!!.application)
        game=repository.getGame(gameId)
        Log.d("test",game.summary)



    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view: View = inflater.inflate(R.layout.game_detail, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        text_description_txt.text = game.summary
        game_name_txt.text=game.name
        text_url.text=game.url
        button_delete.setOnClickListener{
            repository.delete(game)
            fragmentManager?.popBackStack()
        }

    }

}