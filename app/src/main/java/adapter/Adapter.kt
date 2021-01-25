package adapter

import alura.com.ui.R
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import domain.Pokemon

class AdapterPokemon(private val pokemonList: List<Pokemon>) : RecyclerView.Adapter<AdapterPokemon.ViewHold>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHold {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.activity_card_pokemon, parent, false)
        return ViewHold(itemView)
    }

    override fun getItemCount(): Int = pokemonList.size

    override fun onBindViewHolder(holder: ViewHold, position: Int) {
        val currentItem = pokemonList[position]
        holder.name.text = currentItem.name
    }

    class ViewHold(itemView: View): RecyclerView.ViewHolder(itemView){
        val name: TextView = itemView.findViewById(R.id.name_pokemon)
    }
}