package br.com.zup.desafioandroidcore.domain.repository

import br.com.zup.desafioandroidcore.data.datasource.local.dao.ProdutoDAO
import br.com.zup.desafioandroidcore.domain.model.Produto

class ProdutoRepositorio(private val produtoDAO: ProdutoDAO) {
    suspend fun getAllProdutos(): List<Produto> = produtoDAO.getAllProdutos()
    suspend fun insertProduto(produto: Produto) {
        produtoDAO.insertProduto(produto)
    }
}