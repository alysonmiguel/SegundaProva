package tads.eaj.ufrn.segundaprova

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RestauranteViewHolder (v: View) : RecyclerView.ViewHolder(v) {
    val textViewNome: TextView
   // val logo: ImageView

    init {
        textViewNome = v.findViewById(R.id.nomeRestaurante)
      //  logo = v.findViewById(R.id.imgRestaurante)
    }
}