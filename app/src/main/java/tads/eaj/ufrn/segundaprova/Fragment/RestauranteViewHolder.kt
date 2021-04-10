package tads.eaj.ufrn.segundaprova.Fragment

import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import tads.eaj.ufrn.segundaprova.R

class RestauranteViewHolder (v: View) : RecyclerView.ViewHolder(v) {

    val textViewNome: TextView
    val textViewRua: TextView
//    val editTextCidade: EditText
//    val editTextCategoria: EditText
//    val editTextNumero: EditText
//    val editTextNumeroFuncionario: EditText



    init {
        textViewNome = v.findViewById(R.id.nomeRestaurante)
///       editTextNome = v.findViewById(R.id.editTextNome)
        textViewRua = v.findViewById(R.id.ruaRestaurante)
//        editTextCidade = v.findViewById(R.id.editTextCidade)
//        editTextCategoria = v.findViewById(R.id.editTextCategoria)
//        editTextNumero = v.findViewById(R.id.editTextNumero)
//        editTextNumeroFuncionario = v.findViewById(R.id.editTextNumeroFuncionarios)

    }

}