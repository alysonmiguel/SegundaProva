package tads.eaj.ufrn.segundaprova.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import tads.eaj.ufrn.segundaprova.R
import tads.eaj.ufrn.segundaprova.databinding.RestauranteInflaterBinding
import tads.eaj.ufrn.segundaprova.model.Restaurante

class RestauranteAdapter : androidx.recyclerview.widget.ListAdapter<Restaurante, RestauranteAdapter.RestauranteViewHolder>(RestauranteDiffCalback()){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestauranteViewHolder {
        return RestauranteViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: RestauranteViewHolder, position: Int) {
        val restaurante = getItem(position)
        holder.bind(restaurante)
    }

    class RestauranteViewHolder private constructor(val binding: RestauranteInflaterBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(restaurante: Restaurante) {
            binding.restaurante = restaurante
        }

        companion object {
            fun from(parent: ViewGroup): RestauranteViewHolder {
                val inflater = LayoutInflater.from(parent.context)
                val binding:RestauranteInflaterBinding = DataBindingUtil.inflate(inflater, R.layout.restaurante_inflater, parent, false)
                return RestauranteViewHolder(binding)
            }
        }
    }
}

class RestauranteDiffCalback : DiffUtil.ItemCallback<Restaurante>(){

    override fun areItemsTheSame(oldItem: Restaurante, newItem: Restaurante): Boolean {
        return  oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Restaurante, newItem: Restaurante): Boolean {
        return  oldItem == newItem
    }
}