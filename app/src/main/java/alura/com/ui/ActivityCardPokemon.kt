package alura.com.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class activity_card_pokemon : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_card_pokemon)

        var pokemonName = findViewById<TextView>(R.id.name_pokemon)
        pokemonName.text[0].toUpperCase()
    }
}