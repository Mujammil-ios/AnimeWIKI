package com.example.animewiki.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.animewiki.MainActivity
import com.example.animewiki.R
import com.example.animewiki.data.Result
import com.example.animewiki.data.SearchAnime
import com.example.animewiki.ui.ExploreFragment
import com.squareup.picasso.Picasso

class ExploreAdapter(private val parentActivity: ExploreFragment,

                     private val anime: List<Result>): RecyclerView.Adapter<ExploreAdapter.CustomViewHolder>(){
    inner class CustomViewHolder (view: View): RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {


        val view = LayoutInflater.from(parent.context).inflate(R.layout.explore_item_list,parent,false)
        return CustomViewHolder(view)
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        TODO("Not yet implemented")

        val anime =anime[position]
        val view = holder.itemView
        val name = view.findViewById<TextView>(R.id.animeTextView)
        val image= view.findViewById<ImageView>(R.id.animeImageView)


        name.text = anime.title
        Picasso.get().load(anime.imageUrl).into(image)


        view.setOnClickListener {
            TODO("Not yet implemented")
        }

    }

    override fun getItemCount(): Int {
        return anime.size
    }
}











