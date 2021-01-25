package repository

import domain.Pokemon
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface Repository {

    @GET("api/v2/pokemon/{id}")
    fun getPokemonList(@Path("id") id: Int): Call<Pokemon>
}