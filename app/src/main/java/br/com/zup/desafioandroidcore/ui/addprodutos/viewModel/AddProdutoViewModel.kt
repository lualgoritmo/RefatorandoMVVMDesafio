package br.com.zup.desafioandroidcore.ui.addprodutos.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import br.com.zup.desafioandroidcore.domain.model.Produto
import br.com.zup.desafioandroidcore.domain.usecase.ProdutoUseCase
import br.com.zup.desafioandroidcore.ui.viewstate.ViewState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
//MELHOR USAR UM CONTEXTO NO LUGAR DO APPLICATION
class AddProdutoViewModel(application: Application) : AndroidViewModel(application) {
    private val produtoUseCase = ProdutoUseCase(application)
    val produtoAddState = MutableLiveData<ViewState<Produto>>()

    fun insertProduto(produto:Produto) {
        viewModelScope.launch {
            try {
                val response = withContext(Dispatchers.IO) {
                    produtoUseCase.insertProduto(produto)
                }
                produtoAddState.value = response
            } catch (ex: Exception) {
                produtoAddState.value =
                    ViewState.Error(Throwable("Não foi possível inserir o filme!"))
            }
        }
    }
}