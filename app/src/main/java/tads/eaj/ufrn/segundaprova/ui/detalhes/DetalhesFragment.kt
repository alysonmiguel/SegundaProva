package tads.eaj.ufrn.segundaprova.ui.detalhes

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.navigation.ui.NavigationUI
import tads.eaj.ufrn.segundaprova.ui.dialogs.AjudaDialogFragment
import tads.eaj.ufrn.segundaprova.R
import tads.eaj.ufrn.segundaprova.SegundaProvaApplication
import tads.eaj.ufrn.segundaprova.databinding.FragmentDetalhesBinding

class DetalhesFragment : Fragment() {

    lateinit var binding: FragmentDetalhesBinding
    lateinit var viewModel: DetalhesFragmentViewModel

    val args: DetalhesFragmentArgs by navArgs()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_detalhes, container, false)
        val viewModelFactory = DetalhesFragmentViewModel.DetalhesFragmentViewModelFactory(
            args.restauranteId.toLong(),
            (requireActivity().application as SegundaProvaApplication).repository
        )
        viewModel = ViewModelProvider(this, viewModelFactory ).get(DetalhesFragmentViewModel::class.java)

        binding.viewModel  = viewModel
        binding.lifecycleOwner = this

        binding.buttonVoltar.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_detalhesFragment_to_homeFragment)
        }

        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.options_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.ajuda){
            var dialog = AjudaDialogFragment(R.layout.ajuda_detalhes)
            dialog.show(requireActivity().supportFragmentManager, "home ajuda")
        }
        return NavigationUI.onNavDestinationSelected(item, this.findNavController()) || super.onOptionsItemSelected(item)
    }
}