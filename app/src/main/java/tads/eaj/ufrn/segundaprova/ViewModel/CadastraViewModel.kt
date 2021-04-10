package tads.eaj.ufrn.segundaprova.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.room.Room
import tads.eaj.ufrn.segundaprova.DataBase.RestauranteBanco
import tads.eaj.ufrn.segundaprova.Model.Restaurante

class CadastraViewModel(application: Application) : AndroidViewModel(application) {

    var restaurante: Restaurante

    var nome = ""
    var rua = ""
    var cidade = ""
    var categoria = ""
    var numero = 0
    var numeroFuncionarios = 0


     init {
         restaurante = Restaurante(0, nome, rua, cidade, categoria, numero, numeroFuncionarios)
     }


//    var nome = ""
//    var rua = ""
//    var cidade = ""
//    var categoria = ""
//    var numero = 0
//    var numeroFuncionarios = 0
//
//    val db : RestauranteBanco by lazy {
//        Room.databaseBuilder(
//            application.applicationContext,
//            RestauranteBanco::class.java,
//            "Restaurante"
//        ).allowMainThreadQueries().build()  // allowMainThreadQueries permite fazer chamadas na thread principal
//    }
//
//    fun cadastra(nome:String, rua:String, cidade:String, categoria:String, numero:Int, numeroFuncionarios:Int) {
//        var restaurante = Restaurante(0 , nome, rua, cidade, categoria, numero, numeroFuncionarios)
//        db.restauranteDao().cadastrar(restaurante)
//    }


}