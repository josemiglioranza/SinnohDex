package domain

import com.google.gson.annotations.SerializedName

data class Pokemon (
    @SerializedName("name") val name: String,
    @SerializedName("id") val id: Int
)

class AllPokemons {

    class Pokemon(
        @SerializedName("name") val name: String,
        @SerializedName("url") val url: String
    )

    class ListOfPokemons(
        @SerializedName("results") val results: List<Pokemon>
    )
}




