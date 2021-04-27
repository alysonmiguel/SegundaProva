package tads.eaj.ufrn.segundaprova.ui.home.adapter

import android.widget.TextView
import androidx.databinding.BindingAdapter

@BindingAdapter("numeroAsText")
fun TextView.setNumeroAsText(numero: Int?){
    numero?.let {
        text = it.toString()
    }
}

@BindingAdapter("numeroFuncionarioAsText")
fun TextView.setNumeroFuncionarioAsText(numero: Int?){
    numero?.let {
        text = it.toString()
    }
}