package com.example.gamereader.viewmodel

import androidx.lifecycle.LiveData
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.gamereader.BDD.GameRepository
import com.example.gamereader.model.Game


class GamesVM(application: Application) : AndroidViewModel(application) {

    private lateinit  var repository: GameRepository
    lateinit var allgames: LiveData<List<Game>>

    init{
        repository=GameRepository(application)
        allgames=repository.getAllGames()
    }
    fun insert(game: Game) {
        repository.insert(game)
    }

    fun delete(game:Game) {
        repository.delete(game)
    }

    fun getAllGames(): LiveData<List<Game>> {
        return allgames
    }

}