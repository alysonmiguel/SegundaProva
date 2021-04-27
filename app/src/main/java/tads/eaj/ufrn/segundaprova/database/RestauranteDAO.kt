package tads.eaj.ufrn.segundaprova

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface RestauranteDAO {
    @Insert
    fun cadastrar(restaurante: Restaurante)
    @Update
    fun editar( restaurante: Restaurante)
    @Delete
    fun excluir(restaurante: Restaurante)
    @Query("SELECT * FROM RESTAURANTE" )
    fun listaTodos():LiveData<List<Restaurante>>
    @Query("SELECT * FROM RESTAURANTE WHERE id =:id" )
    fun listaPorId(id:Long) : Restaurante
}