package tads.eaj.ufrn.segundaprova.ui.cadastro

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import tads.eaj.ufrn.segundaprova.ui.dialogs.AjudaDialogFragment
import tads.eaj.ufrn.segundaprova.R
import tads.eaj.ufrn.segundaprova.SegundaProvaApplication
import tads.eaj.ufrn.segundaprova.databinding.CadastraFragmentBinding

class CadastraFragment : Fragment() {

    lateinit var viewModel: CadastraFragmentViewModel
    lateinit var binding: CadastraFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.cadastra_fragment, container, false)
        val viewModelFactory = CadastraFragmentViewModel.Factory((requireActivity().application as SegundaProvaApplication).repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(CadastraFragmentViewModel::class.java)

        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        setHasOptionsMenu(true)

        viewModel.eventCadastraRestaurante.observe(viewLifecycleOwner, { hasChanged ->
            if(hasChanged){
                Navigation.findNavController(requireView()).navigate(CadastraFragmentDirections.actionCadastraFragmentToHomeFragment())
                viewModel.onCadastraRestauranteComplete()
            }
        })

        binding.buttonVoltar.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_cadastraFragment_to_homeFragment)
        }

        return binding.root
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.options_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.ajuda){
            var dialog = AjudaDialogFragment(R.layout.ajuda_cadastro)
            dialog.show(requireActivity().supportFragmentManager, "home ajuda")
        }
        return NavigationUI.onNavDestinationSelected(item, this.findNavController()) || super.onOptionsItemSelected(item)
    }
}