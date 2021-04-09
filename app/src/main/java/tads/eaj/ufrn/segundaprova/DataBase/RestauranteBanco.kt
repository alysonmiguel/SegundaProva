package tads.eaj.ufrn.segundaprova.DataBase

import androidx.room.Database
import androidx.room.RoomDatabase
import tads.eaj.ufrn.segundaprova.Model.Restaurante
import tads.eaj.ufrn.segundaprova.Repositorio.RestauranteDAO

@Database(entities = [Restaurante::class], version = 1 )
abstract class RestauranteBanco: RoomDatabase(){
    abstract fun restauranteDao(): RestauranteDAO


}