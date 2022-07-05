package br.com.zup.desafioandroidcore.ui.produtos.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.zup.desafioandroidcore.domain.model.Product
import br.com.zup.desafioandroidcore.databinding.ProdutoItemBinding

class ProdutoAdapter(private var listaProduto: MutableList<Product>, private val onClick:(produto: Product)->Unit) :
    RecyclerView.Adapter<ProdutoAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ProdutoItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val produto = listaProduto[position]
        holder.exibirInformacaoesNaTextView(produto)
        holder.itemView.setOnClickListener {
            onClick(produto)
        }
    }

    override fun getItemCount(): Int {
        return listaProduto.size
    }

    class ViewHolder(val binding: ProdutoItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun exibirInformacaoesNaTextView(produto: Product) {
            binding.txtNome.text = "${produto.quantidade} - ${produto.nome}"
        }
    }
    fun atualizarListaProduto(novaListaProduto: MutableList<Product>) {
        if (listaProduto.size == 0) {
            listaProduto = novaListaProduto
        }
        else {
            listaProduto.addAll(novaListaProduto)
        }
        notifyDataSetChanged()
    }
}