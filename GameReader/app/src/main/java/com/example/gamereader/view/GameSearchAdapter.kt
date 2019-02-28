

package com.example.gamereader.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.gamereader.R
import com.example.gamereader.model.Game





class GameSearchAdapter internal constructor(context: Context) : RecyclerView.Adapter<GameSearchAdapter.GameViewHolder>() {
    private val mInflater: LayoutInflater = LayoutInflater.from(context)
    private var gamelist: List<Game>? = null
    var onItemClick: ((Game) -> Unit)? = null



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder {
        val itemView = mInflater.inflate(com.example.gamereader.R.layout.game_list_search, parent, false)
        return GameViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {

        if (gamelist != null) {
            val game : Game = gamelist!![position]
            holder.gameName.text = game.name
            holder.gameURL.text = game.url
        } else {

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
        notifyDataSetChanged()

    }



    inner class GameViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


        var gameName: TextView
        var gameURL: TextView
        init {
            gameName = itemView.findViewById(R.id.game_name)
            gameURL = itemView.findViewById(R.id.game_url)
            itemView.setOnClickListener {
                gamelist?.get(adapterPosition)?.let { it1 -> onItemClick?.invoke(it1) }

            }
        }


    }
}
