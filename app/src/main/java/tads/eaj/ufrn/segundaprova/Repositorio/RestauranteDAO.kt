package tads.eaj.ufrn.segundaprova.Repositorio

import androidx.lifecycle.LiveData
import androidx.room.*
import tads.eaj.ufrn.segundaprova.Model.Restaurante

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