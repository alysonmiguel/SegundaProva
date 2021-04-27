package tads.eaj.ufrn.segundaprova

import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.Room
import tads.eaj.ufrn.segundaprova.Restaurante

class CadastraFragmentViewModel(application: Application) : AndroidViewModel(application) {

    var restaurante: Restaurante = Restaurante()

    private var _eventCadastraRestaurante = MutableLiveData<Boolean>(false)
    val eventCadastraRestaurante:LiveData<Boolean>
        get() = _eventCadastraRestaurante

    private val db:RestauranteDatabase by lazy {
        Room.databaseBuilder(application.applicationContext, RestauranteDatabase::class.java, "restaurante.sqlite").build()
    }

    fun cadastraRestaurante(){
        CadastrarRestauranteAsyncTask(db.restauranteDao()).execute(restaurante)
        _eventCadastraRestaurante.value = true
    }

    fun onCadastraRestauranteComplete(){
        _eventCadastraRestaurante.value = false
    }

    class CadastrarRestauranteAsyncTask(var restauranteDAO: RestauranteDAO): AsyncTask<Restaurante, Unit,Unit>(){
        override fun doInBackground(vararg params: Restaurante?) {
            return restauranteDAO.cadastrar(params[0]!!)
        }
    }
}