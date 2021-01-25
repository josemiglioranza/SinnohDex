package alura.com.ui

import adapter.AdapterPokemon
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import connection.Connection
import domain.Pokemon
import repository.Repository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    var pokemonList = arrayListOf<Pokemon>()
    lateinit var ordenedPokemons: List<Pokemon>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getTargetPokemon()
        setLayoutAdapter()
    }

    fun setLayoutAdapter() {
        var rec = findViewById<RecyclerView>(R.id.rec)
        rec.layoutManager = LinearLayoutManager(this@MainActivity)
        var adapter = AdapterPokemon(ordenedPokemons)
        rec.adapter = adapter
    }

    fun getTargetPokemon() {
        val conexao = Connection.createService(Repository::class.java)

        for (contador in 387..493){
            val callPokemon: Call<Pokemon> = conexao.getPokemonList(contador)

            callPokemon.enqueue(object : Callback<Pokemon> {
                override fun onFailure(call: Call<Pokemon>, t: Throwable) {
                    println("Não conseguimos pegar o pokémon para você")
                }

                override fun onResponse(call: Call<Pokemon>, response: Response<Pokemon>) {
                    if(response.isSuccessful){
                        response.body()?.let { pokemonList.add(it) }
                    }
                }
            })
        }
        ordenedPokemons = pokemonList.sortedBy { it.id }
    }
}