package tads.eaj.ufrn.segundaprova.Fragment

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavArgs
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
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

        setHasOptionsMenu(true)
        return  binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.options_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if(item.itemId == R.id.ajuda){
            var dialog = DialogFragment(R.layout.ajuda_home)
            dialog.show(requireActivity().supportFragmentManager, "home ajuda")
        }

        return NavigationUI.onNavDestinationSelected(item, this.findNavController()) || super.onOptionsItemSelected(item)
    }

}

