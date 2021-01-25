package domain

import com.google.gson.annotations.SerializedName

data class Pokemon(
        @SerializedName("name") val name: String,
        @SerializedName("id") val id : Int
    )

