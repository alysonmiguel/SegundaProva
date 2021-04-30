package tads.eaj.ufrn.segundaprova

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.LinearLayoutManager
import tads.eaj.ufrn.exemplorecyclerview.MyRecyclerViewClickListener
import tads.eaj.ufrn.segundaprova.databinding.FragmentHomeBinding

@Suppress("UNREACHABLE_CODE")
class HomeFragment : Fragment() {

    lateinit var viewModel: HomeFragmentViewModel
    lateinit var binding: FragmentHomeBinding
    var listAdapter = RestauranteAdapter()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        viewModel = ViewModelProvider(this).get(HomeFragmentViewModel::class.java)


        viewModel.lista.observe(viewLifecycleOwner, {
            listAdapter.list = it
            Log.i("BANCO", it.toString())
            listAdapter.notifyDataSetChanged()
        })

        binding.recyclerRestaurante.adapter = listAdapter
        binding.recyclerRestaurante.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, true)


        binding.recyclerRestaurante.addOnItemTouchListener(MyRecyclerViewClickListener(this.requireActivity(), binding.recyclerRestaurante,
                object : MyRecyclerViewClickListener.OnItemClickListener {
                    override fun onItemClick(view: View, position: Int) {
                        Navigation.findNavController(view).navigate(
                            HomeFragmentDirections.actionHomeFragmentToDetalhesFragment(listAdapter.list[position].id.toInt())
                        )
                    }

                    override fun onItemLongClick(view: View, position: Int) {
                        Navigation.findNavController(view).navigate(
                            HomeFragmentDirections.actionHomeFragmentToAlteraFragment(listAdapter.list[position].id.toInt())
                        )
                    }
                }))

//        binding.cadastrarRestaurante.setOnClickListener {
//            Navigation.findNavController(it).navigate(R.id.action_homeFragment_to_cadastraFragment)
//        }

        binding.buttonAtualizar.setOnClickListener {
           viewModel.getRestaurantes()
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

