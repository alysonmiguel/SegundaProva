package tads.eaj.ufrn.segundaprova.Fragment

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.room.Room
import tads.eaj.ufrn.segundaprova.DataBase.RestauranteBanco
import tads.eaj.ufrn.segundaprova.Model.Restaurante

class AlteraViewModel(application: Application) : AndroidViewModel(application) {

    var  restaurante: Restaurante
    var nome = ""
    var rua = ""
    var cidade = ""
    var categoria = ""
    var numero = ""
    var numeroFuncionarios = ""

    val db : RestauranteBanco by lazy {
        Room.databaseBuilder(
            application.applicationContext,
            RestauranteBanco::class.java,
            "Restaurante"
        ).build()
    }

    init {
        restaurante = db.restauranteDao().listaPorId(1)
        nome = restaurante.nome
        rua = restaurante.rua
        cidade = restaurante.cidade
        categoria = restaurante.categoria
        numero += restaurante.numero
        numeroFuncionarios += restaurante.numeroFuncionarios

    }




//    @SuppressLint("StaticFieldLeak")
//    inner class taskAsync(var db: RestauranteBanco, var id:Long): AsyncTask<Int, Int, Restaurante>() {
//        override fun doInBackground(vararg params: Int?): Restaurante {
//            return db.restauranteDao().listaPorId(id)
//        }
//    }
//
//    fun visualizar(){
//        restaurante = taskAsync(db, 0).execute().get()
//    }

}