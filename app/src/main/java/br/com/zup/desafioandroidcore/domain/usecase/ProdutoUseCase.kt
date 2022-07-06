package br.com.zup.desafioandroidcore.domain.usecase

import android.app.Application
import br.com.zup.desafioandroidcore.data.datasource.local.ProdutoDataBase
import br.com.zup.desafioandroidcore.data.datasource.local.dao.ProdutoDAO
import br.com.zup.desafioandroidcore.domain.model.Produto
import br.com.zup.desafioandroidcore.domain.repository.ProdutoRepositorio
import br.com.zup.desafioandroidcore.ui.viewstate.ViewState

class ProdutoUseCase(application: Application) {
    private val produtoDao = ProdutoDataBase.getDatabase(application).produtoDao()
    private val produtoRepositorio = ProdutoRepositorio(produtoDao)

    suspend fun getAllProdutos(): ViewState<List<Produto>> {
        return try {
            val movies = produtoRepositorio.getAllProdutos()
            ViewState.Success(movies)
        } catch (ex: Exception) {
            ViewState.Error(Exception("Não foi possível carregar a lista de filmes!"))
        }
    }

    suspend fun insertProduto(produto:Produto): ViewState<Produto> {
        return try {
            produtoRepositorio.insertProduto(produto)
            ViewState.Success(produto)
        } catch (ex: Exception) {
            ViewState.Error(Exception("Não foi possível cadastrar o produto!"))
        }
    }
}