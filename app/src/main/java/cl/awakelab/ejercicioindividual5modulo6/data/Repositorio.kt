package cl.awakelab.ejercicioindividual5modulo6.data

import androidx.lifecycle.LiveData
import cl.awakelab.ejercicioindividual5modulo6.data.local.TerrenoDAO
import cl.awakelab.ejercicioindividual5modulo6.data.local.TerrenoEntity
import cl.awakelab.ejercicioindividual5modulo6.data.remote.Terreno
import cl.awakelab.ejercicioindividual5modulo6.data.remote.TerrenoAPI
import retrofit2.Response

class Repositorio(private val terrenoAPI: TerrenoAPI, private val terrenoDAO: TerrenoDAO) {

//    suspend fun cargarTerreno(): List<Terreno> {
//        val response = terrenoAPI.getData()
//        if (response.isSuccessful) {
//            val resp = response.body()
//            resp?.let {
//                return it
//            }
//        }
//        return emptyList()
//    }

    fun obtenerTerrenos(): LiveData<List<TerrenoEntity>> = terrenoDAO.getTerrenosFromEntity()

    suspend fun cargarTerreno() {

        val respuesta: Response<List<Terreno>> = terrenoAPI.getData()

        if(respuesta.isSuccessful) {
            val resp: List<Terreno>? = respuesta.body()
            resp?.let {terrenos ->
                val terrenosEntity = terrenos.map{ it.transformar() }
                terrenoDAO.insertTerrenosFromEntity(terrenosEntity)
            }
        }
    }
}
    fun Terreno.transformar(): TerrenoEntity =
        TerrenoEntity(this.id, this.precio, this.tipo, this.imagen)

