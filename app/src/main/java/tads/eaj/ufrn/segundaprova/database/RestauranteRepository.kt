package tads.eaj.ufrn.segundaprova.database

import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import tads.eaj.ufrn.segundaprova.model.Restaurante

class RestauranteRepository(val restauranteDAO: RestauranteDAO) {

    val listAll: Flow<List<Restaurante>> = restauranteDAO.listAll()
    suspend fun insert(r:Restaurante){
        restauranteDAO.insert(r)
    }

    suspend fun update(r:Restaurante){
        restauranteDAO.update(r)
    }

    suspend fun listById(id:Long):Restaurante = restauranteDAO.listById(id)

    suspend fun getRestaurante(): Response<Restaurante>{
        return  RetrofitInstance.api.getAll()
    }


//    val BASE_URL = " http://localhost:3000"
//    var retrofit : Retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
//    var webService:WebService = retrofit.create((WebService::class.java))

//    suspend fun  getRestaurante( restauranteId: String ) = webService.getRestaurante(restauranteId)

//    val getAll:Flow<List<Restaurante>> = webService.getAll()
}