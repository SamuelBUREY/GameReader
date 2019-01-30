package com.example.gamereader.BDD

import android.content.Context
import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.gamereader.Model.Game
import androidx.room.Room



@Database(entities = arrayOf(Game::class), version = 1)
abstract class GamesDataBase : RoomDatabase() {

    abstract fun gameDAO(): GameDAO



    companion object {
        @Volatile
        private var INSTANCE: GamesDataBase? = null

        fun getDatabase(context: Context): GamesDataBase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    GamesDataBase::class.java,
                    "Games_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }



}