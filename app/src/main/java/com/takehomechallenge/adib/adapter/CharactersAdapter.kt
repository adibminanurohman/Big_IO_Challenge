package com.takehomechallenge.adib.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.takehomechallenge.adib.R
import com.takehomechallenge.adib.models.ListItem

class CharactersAdapter(
    private val UserList: List<ListItem>
): RecyclerView.Adapter<CharactersAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharactersAdapter.MyViewHolder {
        val  itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.item_characters,
            parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return UserList.size
    }

    override fun onBindViewHolder(holder: CharactersAdapter.MyViewHolder, position: Int) {
        val currentItem = UserList[position]

        Glide.with(holder.itemView)
            .load(currentItem.image)
            .into(holder.image)
        holder.name.text = currentItem.name
    }


    class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        var name:TextView = itemView.findViewById(R.id.name)
        var image:ImageView = itemView.findViewById(R.id.img_characters)
    }
}