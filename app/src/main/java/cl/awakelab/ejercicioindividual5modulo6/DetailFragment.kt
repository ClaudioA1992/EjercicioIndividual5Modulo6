package cl.awakelab.ejercicioindividual5modulo6

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import cl.awakelab.ejercicioindividual5modulo6.data.local.TerrenoEntity
import cl.awakelab.ejercicioindividual5modulo6.databinding.FragmentDetailBinding
import coil.load
import com.google.gson.Gson
import com.google.gson.GsonBuilder

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class DetailFragment : Fragment() {

    lateinit var binding: FragmentDetailBinding

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString("terreno")
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val gson: Gson = GsonBuilder().disableHtmlEscaping().create()
        val terreno: TerrenoEntity = gson.fromJson(param1, TerrenoEntity::class.java)
        binding = FragmentDetailBinding.inflate(LayoutInflater.from(activity))

        binding.textViewDetailPrice.text = terreno.precio.toString()
        binding.textViewDetailType.text = terreno.tipo
        binding.imageView.load(terreno.imagen)

        return binding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment DetailFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            DetailFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}