package api

import adapter.AdapterPokemon
import androidx.recyclerview.widget.RecyclerView
import connection.Connection
import domain.AllPokemons
import repository.Repository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PokemonApi {
    fun fetchAllPokemons(recyclerView: RecyclerView){
        val conexao = Connection.createService(Repository::class.java)
        val callPokemon: Call<AllPokemons.ListOfPokemons> = conexao.listOfAllSinnohPokemon(107, 386)

        callPokemon.enqueue(object : Callback<AllPokemons.ListOfPokemons> {
            override fun onFailure(call: Call<AllPokemons.ListOfPokemons>, t: Throwable) {
                println("Não conseguimos pegar o pokémon para você")
            }

            override fun onResponse(
                call: Call<AllPokemons.ListOfPokemons>, response: Response<AllPokemons.ListOfPokemons>
            ) {
                if (response.isSuccessful) {
                    var adapter = AdapterPokemon(response.body()!!)
                    recyclerView.adapter = adapter
                }
            }
        })
    }
}