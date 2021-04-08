package tads.eaj.ufrn.segundaprova.Model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "restaurante")
data class Restaurante(
    @PrimaryKey(autoGenerate = true) val id:Long,
    val nome:String,
    val rua:String,
    val cidade:String,
    val categoria: String,
    val numero:Int,
    val numeroFuncionarios:Int,
    val avaliacao:Float,
    val logo:Int
)
