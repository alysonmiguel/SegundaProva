package tads.eaj.ufrn.segundaprova

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "restaurante")
data class Restaurante(
    @PrimaryKey(autoGenerate = true) val id:Long,
    var nome:String,
    var rua:String,
    var cidade:String,
    var categoria: String,
    var numero:Int,
    var numeroFuncionarios:Int
){
    constructor() : this(0L,"","","","",0,0)
}
