package tads.eaj.ufrn.segundaprova.ui.home

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ActivityRetainedScoped
import kotlinx.coroutines.launch
import retrofit2.Response
import tads.eaj.ufrn.segundaprova.model.Restaurante
import tads.eaj.ufrn.segundaprova.database.RestauranteRepository
import javax.inject.Inject

//@HiltViewModel
class HomeFragmentViewModel (/*savedStateHandle: SavedStateHandle ,*/ val repositorio: RestauranteRepository) : ViewModel(){


//    var lista: LiveData<List<Restaurante>> = repositorio.listAll.asLiveData()
//    var restauranteId : String = savedStateHandle["id"] ?: throw java.lang.IllegalArgumentException("missing id")
    val restaurante:MutableLiveData<Response<Restaurante>> = MutableLiveData()
//    val restaurante: LiveData<Restaurante> = _restaurante

    fun getRestaurante(){
        viewModelScope.launch {
            val response = repositorio.getRestaurante()
            restaurante.value = response
        }
    }



//    init {
//        viewModelScope.launch {
//            _restaurante.value = repositorio.getAll as Restaurante
//        }
//    }

    class Factory( val repositorio: RestauranteRepository): ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(HomeFragmentViewModel::class.java)) {
                return HomeFragmentViewModel(repositorio) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}