package tads.eaj.ufrn.segundaprova.ui.detalhes

import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.*
import androidx.room.Room
import kotlinx.coroutines.launch
import tads.eaj.ufrn.segundaprova.model.Restaurante
import tads.eaj.ufrn.segundaprova.database.RestauranteDAO
import tads.eaj.ufrn.segundaprova.database.RestauranteDatabase
import tads.eaj.ufrn.segundaprova.database.RestauranteRespository

class DetalhesFragmentViewModel private constructor(val id:Long, val restauranteRespository: RestauranteRespository ) : ViewModel() {
    private var _restaurante = MutableLiveData<Restaurante>()
    val restaurante:LiveData<Restaurante>
        get() = _restaurante

    init {
        getRestaurante(id)
    }

    fun getRestaurante(id:Long) {
        viewModelScope.launch {
            _restaurante.value = restauranteRespository.listById(id)
        }
    }

    class DetalhesFragmentViewModelFactory(val id: Long, val restauranteRespository: RestauranteRespository) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(DetalhesFragmentViewModel::class.java)) {
                return DetalhesFragmentViewModel(id, restauranteRespository) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}