package br.com.zup.desafioandroidcore.ui.produtos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.zup.desafioandroidcore.R
import br.com.zup.desafioandroidcore.ui.produtos.view.ProdutoAdapter
import br.com.zup.desafioandroidcore.domain.model.Product
import br.com.zup.desafioandroidcore.databinding.FragmentProdutosCadastradosBinding

class ProdutosCadastrados : Fragment() {
    private lateinit var binding: FragmentProdutosCadastradosBinding
    private val produtoAdapter: ProdutoAdapter by lazy {
        ProdutoAdapter(arrayListOf(),this::onClick)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProdutosCadastradosBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        exibirRecyclerView()
    }
    fun onClick(produto: Product) {
        val bundle = bundleOf("PRODUTO" to produto)
        NavHostFragment.findNavController(this)
            .navigate(R.id.action_produtosCadastrados2_to_detalheProdutoFragment,bundle)
    }
    private fun exibirRecyclerView(){
        binding.rvListaProdutosCadastrados.adapter = produtoAdapter
        binding.rvListaProdutosCadastrados.layoutManager = LinearLayoutManager(context)
    }
    private fun recebendoDados() {
        val produtos = arguments?.getParcelableArrayList<Product>("PRODUTOS")
        if (produtos != null) {
            produtoAdapter.atualizarListaProduto(produtos)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        recebendoDados()
    }

}