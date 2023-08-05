package cl.awakelab.ejercicioindividual5modulo6.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cl.awakelab.ejercicioindividual5modulo6.data.local.TerrenoEntity
import cl.awakelab.ejercicioindividual5modulo6.data.remote.Terreno
import cl.awakelab.ejercicioindividual5modulo6.databinding.ItemTerrenoBinding
import coil.load

class AdapterTerreno: RecyclerView.Adapter<AdapterTerreno.ItemTerrenoViewHolder>() {

    lateinit var binding: ItemTerrenoBinding
    private val listTerrenos = mutableListOf<TerrenoEntity>()

    class ItemTerrenoViewHolder(val view:ItemTerrenoBinding): RecyclerView.ViewHolder(view.root) {
        fun bind(terreno: TerrenoEntity) {
            print(terreno.imagen)
            view.imageViewTerreno.load(terreno.imagen)
            view.textViewType.text = terreno.tipo
            view.textViewPrice.text = terreno.precio.toString()
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemTerrenoViewHolder {
        binding = ItemTerrenoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemTerrenoViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listTerrenos.size
    }

    override fun onBindViewHolder(holder: ItemTerrenoViewHolder, position: Int) {
        val terreno = listTerrenos[position]
        holder.bind(terreno)
    }

    fun setData(terrenos: List<TerrenoEntity>) {
        this.listTerrenos.clear()
        this.listTerrenos.addAll(terrenos)
        notifyDataSetChanged()
    }

}
