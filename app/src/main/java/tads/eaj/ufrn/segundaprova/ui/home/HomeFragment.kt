package tads.eaj.ufrn.segundaprova.ui.home

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.SavedStateViewModelFactory
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.LinearLayoutManager
import tads.eaj.ufrn.segundaprova.util.MyRecyclerViewClickListener
import tads.eaj.ufrn.segundaprova.ui.dialogs.AjudaDialogFragment
import tads.eaj.ufrn.segundaprova.R
import tads.eaj.ufrn.segundaprova.SegundaProvaApplication
import tads.eaj.ufrn.segundaprova.database.RestauranteRepository
import tads.eaj.ufrn.segundaprova.ui.home.adapter.RestauranteAdapter
import tads.eaj.ufrn.segundaprova.databinding.FragmentHomeBinding
import tads.eaj.ufrn.segundaprova.model.Restaurante

@Suppress("UNREACHABLE_CODE")
class HomeFragment : Fragment() {

//    val viewModel: HomeFragmentViewModel by viewModels()
    lateinit var viewModel: HomeFragmentViewModel
    lateinit var binding: FragmentHomeBinding
    var listAdapter = RestauranteAdapter()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)

        val viewModelFactory = HomeFragmentViewModel.Factory( (requireActivity().application as SegundaProvaApplication).repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(HomeFragmentViewModel::class.java)
//
        viewModel.getRestaurante()

        viewModel.restaurante.observe(viewLifecycleOwner, {
//            if (it.isSuccessful){
//                listAdapter.submitList(it as MutableList<Restaurante>)
//                it.body()?.nome.toString()
                Log.i("BANCO", "ALYSON MIGUEL sdfdssdf")
                Log.i("BANCO", it.body()?.nome.toString())
//            }
        })

        binding.recyclerRestaurante.adapter = listAdapter
        binding.recyclerRestaurante.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, true)

        binding.recyclerRestaurante.addOnItemTouchListener(
            MyRecyclerViewClickListener(this.requireActivity(), binding.recyclerRestaurante,
                object : MyRecyclerViewClickListener.OnItemClickListener {
                    override fun onItemClick(view: View, position: Int) {
                        Navigation.findNavController(view).navigate(
                            HomeFragmentDirections.actionHomeFragmentToDetalhesFragment(listAdapter.currentList[position].id.toInt())
                        )
                    }

                    override fun onItemLongClick(view: View, position: Int) {
                        Navigation.findNavController(view).navigate(
                            HomeFragmentDirections.actionHomeFragmentToAlteraFragment(listAdapter.currentList[position].id.toInt())
                        )
                    }
                })
        )

        binding.cadastrarRestaurante.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_homeFragment_to_cadastraFragment)
        }

        setHasOptionsMenu(true)
        return  binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.options_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if(item.itemId == R.id.ajuda){
            var dialog = AjudaDialogFragment(R.layout.ajuda_home)
            dialog.show(requireActivity().supportFragmentManager, "home ajuda")
        }

        return NavigationUI.onNavDestinationSelected(item, this.findNavController()) || super.onOptionsItemSelected(item)
    }

}

