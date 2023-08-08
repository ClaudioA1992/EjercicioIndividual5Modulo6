package cl.awakelab.ejercicioindividual5modulo6.presentation

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import cl.awakelab.ejercicioindividual5modulo6.R
import cl.awakelab.ejercicioindividual5modulo6.data.local.TerrenoEntity
import cl.awakelab.ejercicioindividual5modulo6.databinding.ItemTerrenoBinding
import coil.load
import com.google.gson.Gson
import com.google.gson.GsonBuilder

class AdapterTerreno(): RecyclerView.Adapter<AdapterTerreno.ItemTerrenoViewHolder>() {

    lateinit var binding: ItemTerrenoBinding
    public val listTerrenos = mutableListOf<TerrenoEntity>()

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
        var bundle: Bundle = Bundle()
        val gson: Gson = GsonBuilder().disableHtmlEscaping().create()
        val productJsonString: String = gson.toJson(terreno)
        bundle.putString("terreno", productJsonString)
        holder.itemView.setOnClickListener {
            Navigation.findNavController(binding.getRoot()).navigate(
                R.id.action_listadoFragment_to_detailFragment,
                bundle
            )
        }
        holder.bind(terreno)
    }

    fun setData(terrenos: List<TerrenoEntity>) {
        this.listTerrenos.clear()
        this.listTerrenos.addAll(terrenos)
        notifyDataSetChanged()
    }

}
