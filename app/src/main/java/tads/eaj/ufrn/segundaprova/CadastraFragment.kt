package tads.eaj.ufrn.segundaprova

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.viewModelScope
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import tads.eaj.ufrn.segundaprova.databinding.CadastraFragmentBinding

class CadastraFragment : Fragment() {

    lateinit var fragmentViewModel: CadastraFragmentViewModel
    lateinit var binding: CadastraFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        fragmentViewModel = ViewModelProvider(this).get(CadastraFragmentViewModel::class.java)
        binding = DataBindingUtil.inflate(inflater, R.layout.cadastra_fragment, container, false)

        binding.viewModel = fragmentViewModel
        binding.lifecycleOwner = this

        setHasOptionsMenu(true)

        binding.buttonCadastrar.setOnClickListener {

            if (binding.editTextNome.text.isEmpty() || binding.editTextRua.text.isEmpty() ||
                binding.editTextCidade.text.isEmpty() || binding.editTextCategoria.text.isEmpty() ||
                binding.editTextNumero.text.isEmpty() || binding.editTextNumeroFuncionarios.text.isEmpty()){

                Toast.makeText(this.context, "Preencha todos os campos", Toast.LENGTH_SHORT).show()
            }else {
                fragmentViewModel.cadastraRestaurante()
                Navigation.findNavController(it).navigate(R.id.action_cadastraFragment_to_homeFragment)
            }
        }

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