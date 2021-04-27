package tads.eaj.ufrn.segundaprova

import android.app.Application
import tads.eaj.ufrn.segundaprova.database.RestauranteDatabase
import tads.eaj.ufrn.segundaprova.database.RestauranteRespository

class SegundaProvaApplication: Application() {

    private val database by lazy { RestauranteDatabase.invoke(this)}
    val repository by lazy { RestauranteRespository(database.restauranteDao())}

}
