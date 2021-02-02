package connection

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Connection private constructor() {

    companion object {
        private val baseUrl = "https://pokeapi.co/"
        private val baseUrlSprite = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/"

        private fun getRetrofitInstance() : Retrofit {
            val httpClient = OkHttpClient.Builder()
            return Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(httpClient.build())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        private fun getRetrofitInstanceSprite() : Retrofit {
            val httpClient = OkHttpClient.Builder()
            return Retrofit.Builder()
                .baseUrl(baseUrlSprite)
                .client(httpClient.build())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        fun <T> createService(serviceClass: Class<T>) : T {
            return getRetrofitInstance().create(serviceClass)
        }
    }
}