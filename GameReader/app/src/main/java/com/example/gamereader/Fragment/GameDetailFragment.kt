package com.example.gamereader.Fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.gamereader.R



class GameDetailFragment : Fragment(){

    companion object {
        const val ARG_ID = "id"


        fun newInstance(id: Long): GameDetailFragment {
            val fragment = GameDetailFragment()

            val bundle = Bundle().apply {
                putString(ARG_ID, id.toString())
            }
            fragment.arguments = bundle

            return fragment
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val id : Long? = arguments?.getString(ARG_ID)?.toLong()
        Log.d("idgame",id.toString())
        var view : View =inflater.inflate(R.layout.game_detail,container,false)
        return view
    }


}