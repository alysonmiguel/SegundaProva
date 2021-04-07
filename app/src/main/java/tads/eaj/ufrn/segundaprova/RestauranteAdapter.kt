package tads.eaj.ufrn.segundaprova

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

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
       // holder.logo.setImageResource(restauranteEscolhido.logo)
    }
}