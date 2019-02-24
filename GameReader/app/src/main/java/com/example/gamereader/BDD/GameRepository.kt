package com.example.gamereader.BDD

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.gamereader.model.Game

class GameRepository(application: Application) {

    private var allGames: LiveData<List<Game>>


    private var gameDAO : GameDAO

    init {
        var db = GamesDataBase.getDatabase(application.applicationContext)

        gameDAO=db.gameDAO()
        allGames=gameDAO.getAll()
    }

    fun insert(game : Game){
        gameDAO.insert(game)
    }

    fun delete(game : Game){
        gameDAO.delete(game)
    }

    fun getAllGames(): LiveData<List<Game>> {
        return allGames
    }


}