package tads.eaj.ufrn.segundaprova.ui.detalhes

import androidx.lifecycle.*
import kotlinx.coroutines.launch
import tads.eaj.ufrn.segundaprova.model.Restaurante
import tads.eaj.ufrn.segundaprova.database.RestauranteRepository

class DetalhesFragmentViewModel private constructor(val id:Long, val restauranteRepository: RestauranteRepository ) : ViewModel() {
    private var _restaurante = MutableLiveData<Restaurante>()
    val restaurante:LiveData<Restaurante>
        get() = _restaurante

    init {
        getRestaurante(id)
    }

    fun getRestaurante(id:Long) {
        viewModelScope.launch {
            _restaurante.value = restauranteRepository.listById(id)
        }
    }

    class DetalhesFragmentViewModelFactory(val id: Long, val restauranteRepository: RestauranteRepository) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(DetalhesFragmentViewModel::class.java)) {
                return DetalhesFragmentViewModel(id, restauranteRepository) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}