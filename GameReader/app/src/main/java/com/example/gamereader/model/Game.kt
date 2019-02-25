package com.example.gamereader.model

import androidx.annotation.Nullable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName ="Game")
data class Game(@PrimaryKey(autoGenerate = true) var id: Long, @ColumnInfo(name = "name") var name: String, @ColumnInfo(name = "summary") var summary : String?, @ColumnInfo(name = "storyline")  var storyline : String? , @ColumnInfo(name = "url") var url : String?)

