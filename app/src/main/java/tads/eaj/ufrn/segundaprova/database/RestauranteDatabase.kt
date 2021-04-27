package tads.eaj.ufrn.segundaprova

import androidx.room.Database
import androidx.room.RoomDatabase
import tads.eaj.ufrn.segundaprova.Restaurante
import tads.eaj.ufrn.segundaprova.RestauranteDAO

@Database(entities = [Restaurante::class], version = 1 )
abstract class RestauranteDatabase: RoomDatabase(){
    abstract fun restauranteDao(): RestauranteDAO

}