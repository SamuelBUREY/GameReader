package com.example.gamereader.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.gamereader.Model.Game
import com.example.gamereader.R

class GameAdapter internal constructor(context: Context) : RecyclerView.Adapter<GameAdapter.GameViewHolder>() {
    private val mInflater: LayoutInflater
    private var gamelist: List<Game>? = null

    init {
        mInflater = LayoutInflater.from(context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder {
        val itemView = mInflater.inflate(R.layout.game_list, parent, false)
        return GameViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
        if (gamelist != null) {
            val (game) = gamelist!![position]
            holder.gameView.text = game.toString()
        } else {
            holder.gameView.text = "C'est mon jeu"
        }
    }

    override fun getItemCount(): Int {
        return if (gamelist != null)
            gamelist!!.size
        else
            0
    }

     fun setData(gamesList: List<Game>) {
        this.gamelist = gamesList
        notifyDataSetChanged()
    }

    inner class GameViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val gameView: TextView

        init {
            gameView = itemView.findViewById(R.id.game_name)
        }
    }
}
