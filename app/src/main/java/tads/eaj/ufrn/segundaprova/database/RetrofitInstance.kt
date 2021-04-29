package tads.eaj.ufrn.segundaprova.database

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import tads.eaj.ufrn.segundaprova.util.Constantes

object RetrofitInstance {

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(Constantes.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api: WebService by lazy {
        retrofit.create(WebService::class.java)
    }

}