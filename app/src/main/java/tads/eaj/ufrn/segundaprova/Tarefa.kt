package tads.eaj.ufrn.segundaprova

import android.content.Context
import android.os.AsyncTask
import androidx.lifecycle.LiveData
import androidx.room.Room

class Tarefa (context: Context){
    val db : RestauranteBanco by lazy {
        Room.databaseBuilder(
                context,
                RestauranteBanco::class.java,
                "Restaurante"
        ).allowMainThreadQueries().build()  // allowMainThreadQueries permite fazer chamadas na thread principal
    }

    lateinit var lista:LiveData<List<Restaurante>>
    lateinit var restaurante: Restaurante

    inner class taskAsync: AsyncTask<Long, Int, Long>() {
        override fun doInBackground(vararg params: Long?): Long {
            if (params == null) {
                lista = db.restauranteDao().listaTodos()
            } else {
                var id = params[0]
                restaurante = id?.let { db.restauranteDao().listaPorId(it)}!!
            }
            return 0
        }
    }

    fun buscar(param: Long): LiveData<List<Restaurante>>{
        val t = taskAsync()
        t.execute(param)
        return lista
    }
}