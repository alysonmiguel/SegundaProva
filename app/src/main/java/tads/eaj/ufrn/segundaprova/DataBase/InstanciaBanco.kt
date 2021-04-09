package tads.eaj.ufrn.segundaprova.DataBase

import android.content.Context
import androidx.room.Room

class InstanciaBanco(context: Context) {

    private val db : RestauranteBanco by lazy {
        Room.databaseBuilder(
            context,
            RestauranteBanco::class.java, "Restaurante"
        ).allowMainThreadQueries().build()  // allowMainThreadQueries permite fazer chamadas na thread principal
    }

    fun instanciaBanco() : RestauranteBanco{
        return  db;
    }
}