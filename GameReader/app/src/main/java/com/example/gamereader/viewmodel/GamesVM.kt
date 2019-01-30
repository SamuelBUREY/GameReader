package com.example.gamereader.viewmodel

import androidx.lifecycle.LiveData
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.gamereader.BDD.GameDAO
import com.example.gamereader.BDD.GameRepository
import com.example.gamereader.BDD.GamesDataBase
import com.example.gamereader.Model.Game


class GamesVM(application: Application) : AndroidViewModel(application) {

    private var repository: GameRepository =
        GameRepository(application)
    private var allgames: LiveData<List<Game>> = repository.getAllGames()

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