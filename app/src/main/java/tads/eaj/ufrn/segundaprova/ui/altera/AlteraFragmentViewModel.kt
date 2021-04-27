package tads.eaj.ufrn.segundaprova

import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room

class AlteraFragmentViewModel(id:Long, application: Application) : ViewModel() {
    var restaurante: Restaurante

    private var _eventAlteraRestaurante = MutableLiveData<Boolean>(false)
    val eventAlteraRestaurante:LiveData<Boolean>
        get() = _eventAlteraRestaurante


    private val db: RestauranteDatabase by lazy {
        Room.databaseBuilder(
            application.applicationContext,
            RestauranteDatabase::class.java,
            "restaurante.sqlite"
        )
            .build()
    }

    init {
        restaurante = getRestaurante(id, db.restauranteDao())
    }

    fun alteraRestaurante(){
        AlteraRestauranteAsyncTask(db.restauranteDao()).execute(restaurante)
        _eventAlteraRestaurante.value = true
    }

    fun onAlteraRestauranteComplete(){
        _eventAlteraRestaurante.value = false
    }


    fun getRestaurante(id: Long, restauranteDAO: RestauranteDAO) = GetRestauranteAsyncTask(restauranteDAO).execute(id).get()

    class GetRestauranteAsyncTask(var restauranteDAO: RestauranteDAO) : AsyncTask<Long, Unit, Restaurante>() {
        override fun doInBackground(vararg params: Long?): Restaurante {
            return restauranteDAO.listaPorId(params[0]!!)
        }
    }


    class AlteraRestauranteAsyncTask(var restauranteDAO: RestauranteDAO) : AsyncTask<Restaurante, Unit, Unit>() {
        override fun doInBackground(vararg params: Restaurante?) {
            return restauranteDAO.editar(params[0]!!)
        }
    }

    class AlteraFragmentViewModelFactory(val id: Long, val application: Application) :
        ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(AlteraFragmentViewModel::class.java)) {
                return AlteraFragmentViewModel(id, application) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}