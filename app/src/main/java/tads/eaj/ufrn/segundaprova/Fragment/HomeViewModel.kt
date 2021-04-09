package tads.eaj.ufrn.segundaprova.Fragment

import android.annotation.SuppressLint
import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.room.Room
import tads.eaj.ufrn.segundaprova.DataBase.RestauranteBanco
import tads.eaj.ufrn.segundaprova.Model.Restaurante

class HomeViewModel( application: Application) : AndroidViewModel(application){

    var lista: LiveData<List<Restaurante>>

    init {
        val db : RestauranteBanco by lazy {
            Room.databaseBuilder(
                application.applicationContext,
                RestauranteBanco::class.java,
                "Restaurante"
            ).allowMainThreadQueries().build()  // allowMainThreadQueries permite fazer chamadas na thread principal
        }
//        db.restauranteDao().cadastrar(Restaurante(1, "RU", "Lagoa", "Natal", "serve serve", 45, 10, 5f, 1))
        lista = taskAsync(db).execute().get()
    }

    @SuppressLint("StaticFieldLeak")
    inner class taskAsync(var db: RestauranteBanco): AsyncTask<Int, Int, LiveData<List<Restaurante>>>() {
        override fun doInBackground(vararg params: Int?): LiveData<List<Restaurante>> {
            return db.restauranteDao().listaTodos()
        }
    }

}