package br.com.zup.desafioandroidcore.ui.home.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment
import br.com.zup.desafioandroidcore.R
import br.com.zup.desafioandroidcore.databinding.ActivityHomeBinding
import br.com.zup.desafioandroidcore.databinding.FragmentHomeBinding

class FragmentHome : Fragment() {
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.irParaCadastrarProduto.setOnClickListener {
            NavHostFragment.findNavController(this).navigate(R.id.action_fragmentHome3_to_produtoCadastrar3)
        }
    }
}