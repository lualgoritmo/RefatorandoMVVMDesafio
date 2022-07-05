package br.com.zup.desafioandroidcore.ui.detalheproduto

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.zup.desafioandroidcore.databinding.FragmentDetalheProdutoBinding
import br.com.zup.desafioandroidcore.domain.model.Product


class DetalheProdutoFragment : Fragment() {
    private lateinit var binding:FragmentDetalheProdutoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetalheProdutoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val produto: Product? = arguments?.getParcelable("PRODUTO")
        binding.txtNome.text = produto?.nome
    }
}