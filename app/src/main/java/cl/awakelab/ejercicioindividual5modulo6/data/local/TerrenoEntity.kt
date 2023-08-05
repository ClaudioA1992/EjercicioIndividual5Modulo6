package cl.awakelab.ejercicioindividual5modulo6.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tabla_terrenos")
class TerrenoEntity(@PrimaryKey var id: String, val precio: Long, val tipo: String, val imagen: String) {
}