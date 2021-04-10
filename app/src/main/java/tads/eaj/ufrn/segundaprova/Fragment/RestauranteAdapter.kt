package tads.eaj.ufrn.segundaprova.Fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import tads.eaj.ufrn.segundaprova.Model.Restaurante
import tads.eaj.ufrn.segundaprova.R
import kotlin.coroutines.coroutineContext

class RestauranteAdapter : RecyclerView.Adapter<RestauranteViewHolder>() {

    var restaurantes:List<Restaurante> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestauranteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.restaurante_inflater, parent, false)

        return RestauranteViewHolder(view)
    }
    override fun getItemCount(): Int {
        return restaurantes.size
    }
    override fun onBindViewHolder(holder: RestauranteViewHolder, position: Int) {
        val restauranteEscolhido = restaurantes[position]
        holder.textViewNome.text = restauranteEscolhido.nome
        holder.textViewRua.text = position.toString()

    }




}