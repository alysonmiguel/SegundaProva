package tads.eaj.ufrn.segundaprova

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.navigation.ui.NavigationUI
import tads.eaj.ufrn.segundaprova.databinding.FragmentAlteraBinding

class AlteraFragment : Fragment() {

    lateinit var binding: FragmentAlteraBinding
    lateinit var viewModel: AlteraFragmentViewModel

    val args: AlteraFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ): View? {

        val viewModelFactory = AlteraFragmentViewModel.AlteraFragmentViewModelFactory(args.restauranteId.toLong(), requireActivity().application)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_altera, container, false)
        viewModel = ViewModelProvider(this, viewModelFactory).get(AlteraFragmentViewModel::class.java)

        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        binding.buttonVoltar.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_alteraFragment_to_homeFragment)
        }

        binding.buttonConfirmar.setOnClickListener {

            if (binding.editTextNome.text.isEmpty() || binding.editTextRua.text.isEmpty() ||
                binding.editTextCidade.text.isEmpty() || binding.editTextCategoria.text.isEmpty() ||
                binding.editTextNumero.text.isEmpty() || binding.editTextNumeroFuncionarios.text.isEmpty()){
                Toast.makeText(this.context, "Preencha todos os campos", Toast.LENGTH_SHORT).show()
            }else {
                viewModel.alteraRestaurante()

                Navigation.findNavController(it).navigate(R.id.action_alteraFragment_to_homeFragment)
            }
        }

        setHasOptionsMenu(true)

        viewModel.eventAlteraRestaurante.observe(viewLifecycleOwner, { hasChanged ->
            if (hasChanged == true){
                Navigation.findNavController(requireView()).navigate(AlteraFragmentDirections.actionAlteraFragmentToHomeFragment())
                viewModel.onAlteraRestauranteComplete()
            }
        })

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.options_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if(item.itemId == R.id.ajuda){
            var dialog = AjudaDialogFragment(R.layout.ajuda_altera)
            dialog.show(requireActivity().supportFragmentManager, "home ajuda")
        }

        return NavigationUI.onNavDestinationSelected(item, this.findNavController()) || super.onOptionsItemSelected(item)
    }
}