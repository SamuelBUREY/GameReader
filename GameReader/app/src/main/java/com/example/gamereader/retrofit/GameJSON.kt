package com.example.gamereader.retrofit

import com.google.gson.annotations.SerializedName

class GameJSON (

    @SerializedName("name")
    var name: String,

    @SerializedName("description")
    var description: Long,

    @SerializedName("genre")
    var genre: String){

}
