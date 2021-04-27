package tads.eaj.ufrn.segundaprova.ui.altera

import androidx.lifecycle.*
import kotlinx.coroutines.launch
import tads.eaj.ufrn.segundaprova.model.Restaurante
import tads.eaj.ufrn.segundaprova.database.RestauranteRespository

class AlteraFragmentViewModel private constructor(val id:Long, val restauranteRespository:RestauranteRespository) : ViewModel() {
    private val _restaurante = MutableLiveData<Restaurante>()
    val restaurante:LiveData<Restaurante>
        get() = _restaurante

    private var _eventAlteraRestaurante = MutableLiveData<Boolean>(false)
    val eventAlteraRestaurante:LiveData<Boolean>
        get() = _eventAlteraRestaurante

    init {
        getRestaurante(id)
    }

    fun alteraRestaurante(){
        viewModelScope.launch {
            restaurante.value?.let {
                restauranteRespository.update(it)
            }
        }
        _eventAlteraRestaurante.value = true
    }

    fun onAlteraRestauranteComplete(){
        _eventAlteraRestaurante.value = false
    }

    fun getRestaurante(id: Long){
        viewModelScope.launch {
            _restaurante.value = restauranteRespository.listById(id)
        }
    }

    class AlteraFragmentViewModelFactory(val id: Long, val restauranteRespository: RestauranteRespository) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(AlteraFragmentViewModel::class.java)) {
                return AlteraFragmentViewModel(id, restauranteRespository) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}