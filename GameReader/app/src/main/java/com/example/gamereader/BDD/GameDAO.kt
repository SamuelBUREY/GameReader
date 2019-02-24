package com.example.gamereader.BDD

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.gamereader.model.Game

@Dao
interface GameDAO {
    @Query("SELECT * FROM game")
    fun getAll(): LiveData<List<Game>>

    @Query("SELECT * FROM game WHERE id IN (:gameIds)")
    fun loadAllByIds(gameIds: IntArray): LiveData<List<Game>>

    @Query("SELECT * FROM game WHERE name LIKE :first ")
    fun findByName(first: String): Game

    @Insert
    fun insertAll(vararg games: Game)

    @Delete
    fun delete(game: Game)

    @Insert
    fun insert(game: Game)
}