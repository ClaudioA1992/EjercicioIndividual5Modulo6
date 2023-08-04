package cl.awakelab.ejercicioindividual5modulo6.data.remote

import retrofit2.Response
import retrofit2.http.GET

interface TerrenoAPI {

    @GET("realestate")
    suspend fun getData(): Response<List<Terreno>>

}