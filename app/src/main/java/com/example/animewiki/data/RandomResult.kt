package com.example.animewiki.data

import com.google.gson.annotations.SerializedName

data class RandomResult(



    @SerializedName("name")
    val name: String,
    @SerializedName("image_url")
    val imageUrl: String,
    @SerializedName("mal_id")
    val malId: Int,
    @SerializedName("nicknames")
    val nicknames: String,
    @SerializedName("url")
    val url: String













)
