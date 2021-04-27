package tads.eaj.ufrn.segundaprova

import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room

class DetalhesFragmentViewModel(id:Long, application: Application) : ViewModel() {
    var restaurante:Restaurante
    private val db:RestauranteDatabase by lazy {
        Room.databaseBuilder(application.applicationContext, RestauranteDatabase::class.java, "restaurante.sqlite")
            .build()
    }

    init {
        restaurante = getRestaurante(id, db.restauranteDao())
    }

    fun getRestaurante(id:Long, restauranteDAO: RestauranteDAO) = GetRestauranteAsyncTask(restauranteDAO).execute(id).get()

    class GetRestauranteAsyncTask(var restauranteDAO: RestauranteDAO) : AsyncTask<Long, Unit, Restaurante>() {
        override fun doInBackground(vararg params: Long?): Restaurante {
            return restauranteDAO.listaPorId(params[0]!!)
        }
    }

    class DetalhesFragmentViewModelFactory(val id: Long, val application: Application) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(DetalhesFragmentViewModel::class.java)) {
                return DetalhesFragmentViewModel(id, application) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}