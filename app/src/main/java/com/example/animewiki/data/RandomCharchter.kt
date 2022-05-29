package com.example.animewiki.data

import com.google.gson.annotations.SerializedName

data class RandomCharchter(


    @SerializedName("last_page")
    val lastPage: Int,
    @SerializedName("request_cache_expiry")
    val requestCacheExpiry: Int,
    @SerializedName("request_cached")
    val requestCached: Boolean,
    @SerializedName("request_hash")
    val requestHash: String,
    @SerializedName("results")
    val results: List<RandomResult>
)
