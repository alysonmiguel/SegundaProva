package tads.eaj.ufrn.segundaprova.database

import androidx.lifecycle.LiveData
import androidx.room.*
import kotlinx.coroutines.flow.Flow
import tads.eaj.ufrn.segundaprova.model.Restaurante

@Dao
interface RestauranteDAO {
    @Insert
    suspend fun insert(restaurante: Restaurante)
    @Update
    suspend fun update( restaurante: Restaurante)
    @Delete
    suspend fun delete(restaurante: Restaurante)
    @Query("SELECT * FROM RESTAURANTE" )
    fun listAll():Flow<List<Restaurante>>
    @Query("SELECT * FROM RESTAURANTE WHERE id =:id" )
    suspend fun listById(id:Long) : Restaurante
}