package com.example.gamereader.Model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName ="Game")
data class Game(@PrimaryKey(autoGenerate = true) var id: Long, @ColumnInfo(name = "name") var name: String,@ColumnInfo(name = "description") var description : String,@ColumnInfo(name = "plateform") var plateform : String,@ColumnInfo(name = "genre") var genre : String)

