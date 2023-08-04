package cl.awakelab.ejercicioindividual5modulo6.data

import cl.awakelab.ejercicioindividual5modulo6.data.remote.Terreno
import cl.awakelab.ejercicioindividual5modulo6.data.remote.TerrenoAPI

class Repositorio(private val terrenoAPI: TerrenoAPI) {

    suspend fun cargarTerreno(): List<Terreno> {
        val response = terrenoAPI.getData()
        if(response.isSuccessful) {
            val terrenos = response.body()
            terrenos?.let {
                return it
            }
        }
        return emptyList()
    }

}

