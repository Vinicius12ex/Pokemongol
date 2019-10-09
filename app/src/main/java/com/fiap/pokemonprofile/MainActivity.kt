package com.fiap.pokemonprofile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() , PokemonListService.PokemonCallback, PokemonAdapter.OnItemClick {

    private lateinit var adapter: PokemonAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        PokemonListService(this).getPokemonList()

        val layoutManager = LinearLayoutManager(this)
        recyclerview.layoutManager = layoutManager
        adapter = PokemonAdapter(this)
        recyclerview.adapter = adapter

    }

    override fun onSuccess(pokemon: List<PokemonItem>) {
        adapter.submitList(pokemon)
    }

    override fun onError() {
        //  TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    //TODO
    override fun onClick(id: Int) {

    }
}
