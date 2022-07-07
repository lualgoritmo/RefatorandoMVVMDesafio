package br.com.zup.desafioandroidcore.ui.produtos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.zup.desafioandroidcore.R
import br.com.zup.desafioandroidcore.databinding.FragmentProdutosCadastradosBinding
import br.com.zup.desafioandroidcore.domain.model.Produto
import br.com.zup.desafioandroidcore.ui.produtos.view.ProdutoAdapter
import br.com.zup.desafioandroidcore.ui.produtos.viewmodel.ProdutoViewModel
import br.com.zup.desafioandroidcore.ui.viewstate.ViewState

class ProdutosCadastrados : Fragment() {
    private lateinit var binding: FragmentProdutosCadastradosBinding
    private val produtoAdapter: ProdutoAdapter by lazy {
        ProdutoAdapter(arrayListOf(), this::onClick)
    }
    private val viewModel: ProdutoViewModel by lazy {
        ViewModelProvider(this)[ProdutoViewModel::class.java]
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
        observe()
        viewModel.getAllProdutos()
    }

    fun onClick(produto: Produto) {
        val bundle = bundleOf("PRODUTO" to produto)
        NavHostFragment.findNavController(this)
            .navigate(R.id.action_produtosCadastrados2_to_detalheProdutoFragment, bundle)
    }

    private fun exibirRecyclerView() {
        binding.rvListaProdutosCadastrados.adapter = produtoAdapter
        binding.rvListaProdutosCadastrados.layoutManager = LinearLayoutManager(context)
    }

    private fun recebendoDados() {
        val produtos = arguments?.getParcelableArrayList<Produto>("PRODUTOS")
        if (produtos != null) {
            produtoAdapter.atualizarListaProduto(produtos)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        recebendoDados()
    }
    private fun observe() {
        viewModel.produtoGetState.observe(this.viewLifecycleOwner) {
            when(it) {
                is ViewState.Success-> produtoAdapter.atualizarListaProduto(it.data.toMutableList())
            }
        }
    }
}