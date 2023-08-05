package cl.awakelab.ejercicioindividual5modulo6.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface TerrenoDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTerrenoFromEntity(terrenoEntity: TerrenoEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTerrenosFromEntity(terrenosEntity: List<TerrenoEntity>)

    @Query("SELECT * FROM tabla_terrenos order by id ASC")
    fun getTerrenosFromEntity(): LiveData<List<TerrenoEntity>>


}