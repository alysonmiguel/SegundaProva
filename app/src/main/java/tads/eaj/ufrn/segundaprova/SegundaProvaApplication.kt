package tads.eaj.ufrn.segundaprova

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import tads.eaj.ufrn.segundaprova.database.RestauranteDatabase
import tads.eaj.ufrn.segundaprova.database.RestauranteRepository

class SegundaProvaApplication: Application() {

    private val database by lazy { RestauranteDatabase.invoke(this)}
    val repository by lazy { RestauranteRepository(database.restauranteDao())}

}
