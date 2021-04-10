package tads.eaj.ufrn.segundaprova.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import tads.eaj.ufrn.segundaprova.R
import tads.eaj.ufrn.segundaprova.databinding.FragmentAlteraBinding

class AlteraFragment : Fragment() {

    lateinit var viewModel: AlteraViewModel
    lateinit var binding: FragmentAlteraBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ): View? { // Inflate the layout for this fragment

        viewModel = ViewModelProvider(this).get(AlteraViewModel::class.java)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_altera, container, false)
        binding.lifecycleOwner = this

//        binding.viewmodelalterar = viewModel

        return binding.root
    }

}