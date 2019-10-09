package com.fiap.pokemonprofile

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonAPI {

    @GET("pokemon?limit=40")
    fun getPokemonList() : Call<PokemonResponse>

}