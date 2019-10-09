package com.fiap.pokemonprofile

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class PokemonAdapter(val listener : OnItemClick) : ListAdapter<PokemonItem, PokemonAdapter.PokemonViewHolder>(PokemonDiffUtils()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_pokemon_layout, null)
        return PokemonViewHolder(view)
    }


    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {

        holder.itemView.setOnClickListener {
            listener.onClick(position)
        }
        holder.bind(getItem(position))
    }

    inner class PokemonViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView)  {

        var nameTextView : TextView = itemView.findViewById(R.id.name)

        fun bind(pokemon: PokemonItem){
            nameTextView.text = pokemon.name
        }
    }

    class PokemonDiffUtils : DiffUtil.ItemCallback<PokemonItem>(){
        override fun areItemsTheSame(oldItem: PokemonItem, newItem: PokemonItem): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: PokemonItem, newItem: PokemonItem): Boolean {
            return oldItem.name == newItem.name
        }

    }

    //TODO
    interface OnItemClick{
        fun onClick(id : Int)
    }
}