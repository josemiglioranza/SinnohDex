package alura.com.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import api.PokemonApi

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializeRecylerView()
    }

    fun initializeRecylerView(){
        var rec = findViewById<RecyclerView>(R.id.rec)
        var fetchPokemon = PokemonApi()
        fetchPokemon.fetchAllPokemons(rec)
    }
}
