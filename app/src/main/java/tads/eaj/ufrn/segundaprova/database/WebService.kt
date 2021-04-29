package tads.eaj.ufrn.segundaprova.database

import android.telecom.Call
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import tads.eaj.ufrn.segundaprova.model.Restaurante


interface WebService {
//    @GET("/restaurantes/{id}")
//    suspend fun getRestaurante(@Path("id") restauranteId: String): Restaurante

    @GET("/restaurantes")
    suspend fun getAll(): Response<Restaurante>
}