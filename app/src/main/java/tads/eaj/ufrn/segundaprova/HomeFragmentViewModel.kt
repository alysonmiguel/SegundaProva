package tads.eaj.ufrn.segundaprova

import android.annotation.SuppressLint
import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.room.Room

class HomeFragmentViewModel(application: Application) : AndroidViewModel(application){

    var lista: LiveData<List<Restaurante>>

    private val db:RestauranteDatabase by lazy {
        Room.databaseBuilder(
            application.applicationContext,
            RestauranteDatabase::class.java,
            "restaurante.sqlite"
        ).build()
    }

    init {
        lista = db.restauranteDao().listaTodos()
    }
}