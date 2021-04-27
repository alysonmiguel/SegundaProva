package tads.eaj.ufrn.segundaprova.ui.home

import android.app.Application
import androidx.lifecycle.*
import androidx.room.Room
import tads.eaj.ufrn.segundaprova.model.Restaurante
import tads.eaj.ufrn.segundaprova.database.RestauranteDatabase
import tads.eaj.ufrn.segundaprova.database.RestauranteRespository
import tads.eaj.ufrn.segundaprova.ui.altera.AlteraFragmentViewModel

class HomeFragmentViewModel private  constructor(repositorio: RestauranteRespository) : ViewModel(){

    var lista: LiveData<List<Restaurante>> = repositorio.listAll.asLiveData()

    class Factory(val repositorio: RestauranteRespository): ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(HomeFragmentViewModel::class.java)) {
                return HomeFragmentViewModel(repositorio) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}