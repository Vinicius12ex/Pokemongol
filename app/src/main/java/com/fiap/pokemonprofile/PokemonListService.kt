package com.fiap.pokemonprofile

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PokemonListService(var callback : PokemonCallback) : Callback<PokemonResponse> {

    fun getPokemonList() {
        val call = Injector().pokemonApi.getPokemonList()
        call.enqueue(this)
    }

    override fun onFailure(call: Call<PokemonResponse>?, t: Throwable?) {
        callback.onError()
    }

    override fun onResponse(call: Call<PokemonResponse>, response: Response<PokemonResponse>) {
        if (response.isSuccessful) {
            val pokemonResponse = response.body()
            if (pokemonResponse != null) {
                callback.onSuccess(pokemonResponse.results)
            }
        } else {
            System.out.println(response.errorBody())
        }
    }


    interface PokemonCallback {
        fun onSuccess(pokemon: List<PokemonItem>)
        fun onError()
    }

}
