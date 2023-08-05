package cl.awakelab.ejercicioindividual5modulo6.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import cl.awakelab.ejercicioindividual5modulo6.data.Repositorio
import cl.awakelab.ejercicioindividual5modulo6.data.local.TerrenoDAO
import cl.awakelab.ejercicioindividual5modulo6.data.local.TerrenoDatabase
import cl.awakelab.ejercicioindividual5modulo6.data.remote.DatabaseRetrofit
import cl.awakelab.ejercicioindividual5modulo6.data.remote.Terreno
import cl.awakelab.ejercicioindividual5modulo6.data.remote.TerrenoAPI
import kotlinx.coroutines.launch

class TerrenoVM(application: Application): AndroidViewModel(application) {

    private val repositorio: Repositorio
    fun terrenosLiveData() = repositorio.obtenerTerrenos()

    init {
        val api = DatabaseRetrofit.getRetrofitClient()
        val terrenoDB: TerrenoDAO = TerrenoDatabase.getDataBase(application).getTerrenoFromDao()
        repositorio = Repositorio(api, terrenoDB)
    }

    fun obtenerTerrenos() = viewModelScope.launch {
        repositorio.cargarTerreno()
    }

}

