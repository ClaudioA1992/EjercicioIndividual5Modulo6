package cl.awakelab.ejercicioindividual5modulo6.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import cl.awakelab.ejercicioindividual5modulo6.R
import cl.awakelab.ejercicioindividual5modulo6.databinding.FragmentListadoBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ListadoFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ListadoFragment : Fragment() {

    lateinit var binding: FragmentListadoBinding
    private val terrenoVM: TerrenoVM by activityViewModels()
    private var adapter = AdapterTerreno()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListadoBinding.inflate(layoutInflater)
        initListeners()
        return binding.root
    }

    private fun initAdapter() {
        adapter = AdapterTerreno()
        binding.recyclerView.adapter = adapter
        terrenoVM.terrenosLiveData().observe(viewLifecycleOwner) {
            adapter.setData(it)
        }
    }

    private fun initListeners() {
        binding.buttonLoad.setOnClickListener {
            initAdapter()
        }
    }

}

