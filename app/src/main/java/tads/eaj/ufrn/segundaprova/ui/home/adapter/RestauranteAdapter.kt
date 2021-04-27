package tads.eaj.ufrn.segundaprova

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RestauranteAdapter : RecyclerView.Adapter<RestauranteAdapter.RestauranteViewHolder>() {

    var list:List<Restaurante> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestauranteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.restaurante_inflater, parent, false)
        return RestauranteViewHolder(view)
    }
    override fun getItemCount(): Int {
        return list.size
    }
    override fun onBindViewHolder(holder: RestauranteViewHolder, position: Int) {
        val restauranteEscolhido = list[position]
        holder.textViewNome.text = restauranteEscolhido.nome
        holder.textViewRua.text = restauranteEscolhido.rua
//        holder.textViewCidade.text = restauranteEscolhido.cidade
//        holder.textViewCategoria.text = restauranteEscolhido.categoria
//        holder.textViewNumero.text = restauranteEscolhido.numero.toString()
//        holder.textViewNF.text = restauranteEscolhido.numeroFuncionarios.toString()
    }

    class RestauranteViewHolder (v: View) : RecyclerView.ViewHolder(v) {
        var textViewNome = v.findViewById<TextView>(R.id.nomeRestaurante)
        var textViewRua = v.findViewById<TextView>(R.id.ruaRestaurante)
//        var textViewCidade = v.findViewById<TextView>(R.id.cidadeRestaurante)
//        var textViewCategoria = v.findViewById<TextView>(R.id.categoriaRestaurante)
//        var textViewNumero = v.findViewById<TextView>(R.id.numeroRestaurante)
//        var textViewNF = v.findViewById<TextView>(R.id.nfRestaurante)

    }


}