package tads.eaj.ufrn.segundaprova.database

import kotlinx.coroutines.flow.Flow
import tads.eaj.ufrn.segundaprova.model.Restaurante

class RestauranteRespository(val restauranteDAO: RestauranteDAO) {

    val listAll: Flow<List<Restaurante>> = restauranteDAO.listAll()

    suspend fun insert(r:Restaurante){
        restauranteDAO.insert(r)
    }

    suspend fun update(r:Restaurante){
        restauranteDAO.update(r)
    }

    suspend fun listById(id:Long):Restaurante = restauranteDAO.listById(id)

}