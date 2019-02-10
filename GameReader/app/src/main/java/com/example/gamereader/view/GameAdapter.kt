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
    private val mInflater: LayoutInflater = LayoutInflater.from(context)
    private var gamelist: List<Game>? = null
    var onItemClick: ((Game) -> Unit)? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder {
        val itemView = mInflater.inflate(R.layout.game_list, parent, false)
        return GameViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
        if (gamelist != null) {
            val game : Game = gamelist!![position]
            holder.gameName.text = game.name
            holder.gameGenre.text = game.genre
            holder.gamePlateforme.text = game.plateform
        } else {
            //holder.gameView.text = "C'est mon jeu"
        }
    }

    override fun getItemCount(): Int {
        return if (gamelist != null)
            gamelist!!.size
        else
            0
    }

    fun setData(it: List<Game>) {
        gamelist=it
        notifyDataSetChanged();
    }

    inner class GameViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var gameName: TextView
        var gameGenre: TextView
        var gamePlateforme: TextView


        init {
            gameName = itemView.findViewById(R.id.game_name)
            gameGenre = itemView.findViewById(R.id.game_genre)
            gamePlateforme = itemView.findViewById(R.id.game_plateforme)
            itemView.setOnClickListener {
                gamelist?.get(adapterPosition)?.let { game -> onItemClick?.invoke(game) }

            }
        }
    }
}

