package tads.eaj.ufrn.segundaprova

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.room.Room

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val db : RestauranteBanco by lazy {
//            Room.databaseBuilder(
//                application.applicationContext,
//                RestauranteBanco::class.java,
//                "Restaurante"
//            ).allowMainThreadQueries().build()  // allowMainThreadQueries permite fazer chamadas na thread principal
//        }

    }
}