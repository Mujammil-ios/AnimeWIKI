package com.example.animewiki.api

import com.example.animewiki.data.RandomCharchter
import com.example.animewiki.data.SearchAnime
import com.example.animewiki.data.TopAnime
import com.example.animewiki.utilities.AnimeObject
import io.reactivex.plugins.RxJavaPlugins
//import com.example.animewiki.data.searchAnime
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface JikanRetrofit {

    @GET("top/anime")
    fun getTopAnime(): Call<TopAnime>

    @GET("search/anime")
    fun getSearchAnime(@Query("q")queryString: String):Call<SearchAnime>
    companion object{
        val BASE_URL = "https://api.jikan.moe/v4/"

        fun create(): JikanRetrofit{
            val retrofit = Retrofit.Builder()
                .addConverterFactory(AnimeObject.gsonConverter)
                .baseUrl(BASE_URL)
                .client(AnimeObject.client)
                .build()
            return retrofit.create(JikanRetrofit::class.java)
        }

    }

    @GET("random/characters")
    fun getRandomCharchter(): Call<RandomCharchter>




}







