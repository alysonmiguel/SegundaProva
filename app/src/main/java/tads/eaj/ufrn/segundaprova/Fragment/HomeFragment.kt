package tads.eaj.ufrn.segundaprova.Fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavArgs
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import tads.eaj.ufrn.exemplorecyclerview.MyRecyclerViewClickListener
import tads.eaj.ufrn.segundaprova.R
import tads.eaj.ufrn.segundaprova.ViewModel.HomeViewModel
import tads.eaj.ufrn.segundaprova.databinding.FragmentHomeBinding

@Suppress("UNREACHABLE_CODE")
class HomeFragment : Fragment() {

    lateinit var homeViewModel: HomeViewModel
    lateinit var binding: FragmentHomeBinding
    var listAdapter = RestauranteAdapter()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)


        homeViewModel.lista.observe(viewLifecycleOwner, {
            listAdapter.restaurantes = it
            Log.i("BANCO", it.toString())
            listAdapter.notifyDataSetChanged()
        })

        binding.recyclerView.adapter = listAdapter

        binding.recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, true)

        binding.cadastrarRestaurante.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_homeFragment_to_cadastraFragment)
        }

        binding.recyclerView.addOnItemTouchListener(
            MyRecyclerViewClickListener(
                this.requireActivity(),
                binding.recyclerView,
                object : MyRecyclerViewClickListener.OnItemClickListener {

                    override fun onItemClick(view: View, position: Int) {
                        Navigation.findNavController(requireView()).navigate(HomeFragmentDirections.actionHomeFragmentToDetalhesFragment( position +1))
                    }

                    override fun onItemLongClick(view: View, position: Int) {
                        Navigation.findNavController(requireView()).navigate(HomeFragmentDirections.actionHomeFragmentToAlteraFragment(position+1))
                    }

                })
        )

        return  binding.root
    }
}
