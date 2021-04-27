package tads.eaj.ufrn.segundaprova.ui.cadastro

import androidx.lifecycle.*
import kotlinx.coroutines.launch
import tads.eaj.ufrn.segundaprova.model.Restaurante
import tads.eaj.ufrn.segundaprova.database.RestauranteRespository

class CadastraFragmentViewModel(val restauranteRespository: RestauranteRespository) : ViewModel() {

    var restaurante: Restaurante = Restaurante()

    private var _eventCadastraRestaurante = MutableLiveData<Boolean>(false)
    val eventCadastraRestaurante:LiveData<Boolean>
        get() = _eventCadastraRestaurante

    fun cadastraRestaurante(){
        viewModelScope.launch {
            restauranteRespository.insert(restaurante)
        }
        _eventCadastraRestaurante.value = true
    }

    fun onCadastraRestauranteComplete(){
        _eventCadastraRestaurante.value = false
    }

    class Factory(val repositorio: RestauranteRespository): ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(CadastraFragmentViewModel::class.java)) {
                return CadastraFragmentViewModel(repositorio) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }

}