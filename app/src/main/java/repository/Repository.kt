package repository

import domain.AllPokemons
import domain.Pokemon
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface Repository {

    // pokemon?limit=107&offset=386

    @GET("api/v2/pokemon/")
    fun listOfAllSinnohPokemon(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): Call<AllPokemons.ListOfPokemons>

    @GET("api/v2/pokemon/{id}")
    fun getPokemonList(@Path("id") id: Int): Call<Pokemon>

}