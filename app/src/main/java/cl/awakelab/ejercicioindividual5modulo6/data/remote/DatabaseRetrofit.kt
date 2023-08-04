package cl.awakelab.ejercicioindividual5modulo6.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DatabaseRetrofit {

    companion object {
        private const val URL_BASE =
            "https://android-kotlin-fun-mars-server.appspot.com/"

        fun getRetrofitClient() : TerrenoAPI {
            val mRetrofit = Retrofit.Builder()
                .baseUrl(URL_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return mRetrofit.create(TerrenoAPI::class.java)
        }
    }

}

