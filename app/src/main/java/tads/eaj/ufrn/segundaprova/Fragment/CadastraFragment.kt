package tads.eaj.ufrn.segundaprova.Fragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.room.Room
import tads.eaj.ufrn.segundaprova.DataBase.InstanciaBanco
import tads.eaj.ufrn.segundaprova.DataBase.RestauranteBanco
import tads.eaj.ufrn.segundaprova.R
import tads.eaj.ufrn.segundaprova.Repositorio.RestauranteDAO
import tads.eaj.ufrn.segundaprova.databinding.CadastraFragmentBinding

class CadastraFragment : Fragment() {

//    companion object {
//        fun newInstance() = CadastraFragment()
//    }

    lateinit var viewModel: CadastraViewModel
    lateinit var binding: CadastraFragmentBinding
    lateinit var banco: InstanciaBanco


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        viewModel = ViewModelProvider(this).get(CadastraViewModel::class.java)
        binding = DataBindingUtil.inflate(inflater, R.layout.cadastra_fragment, container, false)
        banco = InstanciaBanco(inflater.context)


        binding.buttonCadastrar.setOnClickListener {

            if (binding.editTextNome.text.isEmpty() || binding.editTextRua.text.isEmpty() ||
                binding.editTextCidade.text.isEmpty() || binding.editTextCategoria.text.isEmpty() ||
                binding.editTextNumero.text.isEmpty() || binding.editTextNumeroFuncionarios.text.isEmpty()){

                Toast.makeText(this.context, "Preencha todos os campos", Toast.LENGTH_SHORT).show()
            }else {
                viewModel.restaurante.nome = binding.editTextNome.text.toString();
                viewModel.restaurante.rua = binding.editTextRua.text.toString();
                viewModel.restaurante.cidade = binding.editTextCidade.text.toString();
                viewModel.restaurante.categoria = binding.editTextCategoria.text.toString();
                viewModel.restaurante.numero = binding.editTextNumero.text.toString().toInt();
                viewModel.restaurante.numeroFuncionarios = binding.editTextNumeroFuncionarios.text.toString().toInt();

                banco.instanciaBanco().restauranteDao().cadastrar(viewModel.restaurante)

                Navigation.findNavController(it).navigate(R.id.action_cadastraFragment_to_homeFragment)
            }
        }

        binding.buttonVoltar.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_cadastraFragment_to_homeFragment)
        }

        return binding.root
    }

}