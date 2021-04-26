package tads.eaj.ufrn.segundaprova

import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.AndroidViewModel
import androidx.room.Room
import tads.eaj.ufrn.segundaprova.Restaurante

class CadastraFragmentViewModel(application: Application) : AndroidViewModel(application) {

    var restaurante: Restaurante = Restaurante()

    private val db:RestauranteDatabase by lazy {
        Room.databaseBuilder(application.applicationContext, RestauranteDatabase::class.java, "restaurante.sqlite").build()
    }

    fun cadastraRestaurante() = CadastrarRestauranteAsyncTask(db.restauranteDao()).execute(restaurante)

    class CadastrarRestauranteAsyncTask(var restauranteDAO: RestauranteDAO): AsyncTask<Restaurante, Unit,Unit>(){
        override fun doInBackground(vararg params: Restaurante?) {
            return restauranteDAO.cadastrar(params[0]!!)
        }
    }
}