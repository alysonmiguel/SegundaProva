package tads.eaj.ufrn.segundaprova.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import tads.eaj.ufrn.segundaprova.DataBase.InstanciaBanco
import tads.eaj.ufrn.segundaprova.Model.Restaurante
import tads.eaj.ufrn.segundaprova.R
import tads.eaj.ufrn.segundaprova.databinding.FragmentAlteraBinding
import tads.eaj.ufrn.segundaprova.databinding.FragmentDetalhesBinding

class DetalhesFragment : Fragment() {

    lateinit var binding: FragmentDetalhesBinding
    lateinit var instancia: InstanciaBanco
    lateinit var restaurante: Restaurante

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_detalhes, container, false)
        instancia = InstanciaBanco(inflater.context)

        val args: AlteraFragmentArgs by navArgs()

        restaurante = instancia.instanciaBanco().restauranteDao().listaPorId(args.restauranteId.toLong())

        binding.textViewNome.setText("Nome = ${restaurante.nome}")
        binding.textViewRua.setText("Rua = ${restaurante.rua}")
        binding.textViewCidade.setText("Cidade = ${restaurante.cidade}")
        binding.textViewCategoria.setText("Categoria = ${restaurante.categoria}")
        binding.textViewNumero.setText("Numero = ${restaurante.numero.toString()}")
        binding.textViewNFuncionario.setText("N° Funcionários = ${restaurante.numeroFuncionarios.toString()}")

        binding.buttonVoltar.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_detalhesFragment_to_homeFragment)
        }
        return binding.root
    }

}