package tads.eaj.ufrn.segundaprova

import android.annotation.SuppressLint
import android.app.Application
import android.os.AsyncTask
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.room.Room
import com.google.gson.GsonBuilder
import okhttp3.*
import java.io.IOException


class HomeFragmentViewModel(application: Application) : AndroidViewModel(application){

    var lista: LiveData<List<Restaurante>>

    private val db:RestauranteDatabase by lazy {
        Room.databaseBuilder(
            application.applicationContext,
            RestauranteDatabase::class.java,
            "restaurante.sqlite"
        ).build()
    }

    init {
        lista = db.restauranteDao().listaTodos()
    }

    fun getRestaurantes(){
        val url = "https://my-json-server.typicode.com/alysonmiguel/json-server/restaurantes"
        val client = OkHttpClient()
        val request= Request.Builder().url(url).build()

        client.newCall(request).enqueue(object :Callback {

            override fun onResponse(call: Call?, response: Response?) {
                val data = response?.body()?.string()
                val gson = GsonBuilder().create()

                val listaRestaurante = gson.fromJson(data, Array<Restaurante>::class.java).toList()

                Log.i("test", listaRestaurante.toString())
            }

            override fun onFailure(call: Call?, e: IOException?) {
                println("Failed to execute request")
            }
        })

    }

}