package tads.eaj.ufrn.segundaprova

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Restaurante::class], version = 1 )
abstract class RestauranteBanco: RoomDatabase(){
    abstract fun restauranteDao(): RestauranteDAO

}