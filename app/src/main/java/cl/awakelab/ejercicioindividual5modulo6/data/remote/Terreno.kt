package cl.awakelab.ejercicioindividual5modulo6.data.remote

import com.google.gson.annotations.SerializedName

class Terreno(
    val id: String,
    @SerializedName("price") val precio: Long,
    @SerializedName("type") val tipo: String,
    @SerializedName("img_src") val imagen: String)