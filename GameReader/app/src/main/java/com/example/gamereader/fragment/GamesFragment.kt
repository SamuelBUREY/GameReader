package com.example.gamereader.fragment

import android.content.Context
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.gamereader.databinding.GamesFragmentListBinding
import com.example.gamereader.model.Game
import com.example.gamereader.view.GameAdapter
import com.example.gamereader.viewmodel.GamesVM
import kotlinx.android.synthetic.main.games_fragment_list.*
import kotlin.random.Random


class GamesFragment : Fragment(),GameAdapter.Callbacks {

    private lateinit var  gameViewModel: GamesVM
    private  var  gameAdapter: GameAdapter = GameAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        gameViewModel = ViewModelProviders.of(this).get(GamesVM::class.java)
        gameViewModel.allgames.observe(this, Observer {
            gameAdapter.submitList(it)
        })
        gameViewModel.insert(Game(Random.nextLong(),"halo","test summary","storyline","https..dlkmdl"))

        setHasOptionsMenu(true)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding : GamesFragmentListBinding = GamesFragmentListBinding.inflate(inflater)
        binding.gameViewModel = gameViewModel
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        games_recycler.adapter = gameAdapter
        game_Add_Button.setOnClickListener { researchGame() }

    }






    fun researchGame() {
        listener?.researchGame()
    }


    override fun onGameSelected(gameID: Long) {
        listener?.onGameSelected(gameID)
    }


    interface OnInteractionListener {
        fun onGameSelected(gameID: Long)
        fun researchGame()
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