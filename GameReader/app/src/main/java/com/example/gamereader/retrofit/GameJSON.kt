package com.example.gamereader.retrofit

import com.google.gson.annotations.SerializedName

class GameJSON (

    @SerializedName("name")
    var name: String,

    @SerializedName("storyline")
    var storyline: Long,

    @SerializedName("url")
    var url: String,

    @SerializedName("summary")
    var summary : String)



