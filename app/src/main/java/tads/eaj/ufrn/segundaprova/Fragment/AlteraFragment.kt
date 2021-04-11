package tads.eaj.ufrn.segundaprova.Fragment

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.navigation.ui.NavigationUI
import tads.eaj.ufrn.segundaprova.DataBase.InstanciaBanco
import tads.eaj.ufrn.segundaprova.Model.Restaurante
import tads.eaj.ufrn.segundaprova.R
import tads.eaj.ufrn.segundaprova.databinding.FragmentAlteraBinding

class AlteraFragment : Fragment() {

    lateinit var binding: FragmentAlteraBinding
    lateinit var instancia: InstanciaBanco
    lateinit var restaurante: Restaurante

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_altera, container, false)
        instancia = InstanciaBanco(inflater.context)

        val args: AlteraFragmentArgs by navArgs()

        restaurante = instancia.instanciaBanco().restauranteDao().listaPorId(args.restauranteId.toLong())

        binding.editTextNome.setText(restaurante.nome)
        binding.editTextRua.setText(restaurante.rua)
        binding.editTextCidade.setText(restaurante.cidade)
        binding.editTextCategoria.setText(restaurante.categoria)
        binding.editTextNumero.setText(restaurante.numero.toString())
        binding.editTextNumeroFuncionarios.setText(restaurante.numeroFuncionarios.toString())

        binding.buttonVoltar.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_alteraFragment_to_homeFragment)
        }

        binding.buttonConfirmar.setOnClickListener {

            if (binding.editTextNome.text.isEmpty() || binding.editTextRua.text.isEmpty() ||
                binding.editTextCidade.text.isEmpty() || binding.editTextCategoria.text.isEmpty() ||
                binding.editTextNumero.text.isEmpty() || binding.editTextNumeroFuncionarios.text.isEmpty()){

                Toast.makeText(this.context, "Preencha todos os campos", Toast.LENGTH_SHORT).show()
            }else {
                val nome = binding.editTextNome.text.toString();
                val rua = binding.editTextRua.text.toString();
                val cidade = binding.editTextCidade.text.toString();
                val categoria = binding.editTextCategoria.text.toString();
                val numero = binding.editTextNumero.text.toString().toInt();
                val numeroFuncionarios = binding.editTextNumeroFuncionarios.text.toString().toInt();

                instancia.instanciaBanco().restauranteDao().editar(Restaurante(args.restauranteId.toLong(), nome, rua, cidade, categoria, numero, numeroFuncionarios))

                Navigation.findNavController(it).navigate(R.id.action_alteraFragment_to_homeFragment)
            }
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
            var dialog = DialogFragment(R.layout.ajuda_altera)
            dialog.show(requireActivity().supportFragmentManager, "home ajuda")
        }

        return NavigationUI.onNavDestinationSelected(item, this.findNavController()) || super.onOptionsItemSelected(item)
    }
}