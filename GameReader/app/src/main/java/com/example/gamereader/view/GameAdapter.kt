package com.example.gamereader.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.gamereader.model.Game
import com.example.gamereader.databinding.GameListBinding




class GameAdapter (private val listener: Callbacks)
    : ListAdapter<Game, GameAdapter.GameViewHolder>(GameDiffCallback()) {

    interface Callbacks {
        fun onGameSelected(gameID: Long)
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        GameViewHolder(GameListBinding.inflate(LayoutInflater.from(parent.context)), listener)

    override fun onBindViewHolder(holder: GameViewHolder, position: Int) = holder.bind(getItem(position))

    class GameViewHolder(private val binding: GameListBinding, listener: Callbacks)
        : RecyclerView.ViewHolder(binding.root) {
        init {
            itemView.setOnClickListener { binding.game?.let { listener.onGameSelected(it.id) } }
        }

        val game get() = binding.game

        fun bind(game: Game) {
            binding.game = game
            binding.executePendingBindings()
        }
    }

    private class GameDiffCallback : DiffUtil.ItemCallback<Game>() {
        override fun areItemsTheSame(oldItem: Game, newItem: Game) = oldItem.id == newItem.id
        override fun areContentsTheSame(oldItem: Game, newItem: Game) = oldItem == newItem
    }
}

