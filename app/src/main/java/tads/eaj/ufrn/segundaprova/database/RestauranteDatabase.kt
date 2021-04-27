package tads.eaj.ufrn.segundaprova.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import tads.eaj.ufrn.segundaprova.model.Restaurante

@Database(entities = [Restaurante::class], version = 1 )
abstract class RestauranteDatabase: RoomDatabase(){
    abstract fun restauranteDao(): RestauranteDAO

    companion object{
        @Volatile private var instance: RestauranteDatabase? = null
        private var LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK){
            instance ?: buildDatabase(context).also { instance = it }
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(context, RestauranteDatabase::class.java, "restaurante_database.db")
            .fallbackToDestructiveMigration()
            .build()
        }

}