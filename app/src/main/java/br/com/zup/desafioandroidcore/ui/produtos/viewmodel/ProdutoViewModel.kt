package br.com.zup.desafioandroidcore.ui.produtos.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import br.com.zup.desafioandroidcore.domain.model.Produto
import br.com.zup.desafioandroidcore.domain.model.SingleLiveEvent
import br.com.zup.desafioandroidcore.domain.usecase.ProdutoUseCase
import br.com.zup.desafioandroidcore.ui.viewstate.ViewState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ProdutoViewModel(application: Application) : AndroidViewModel(application) {
    private val produtoUseCase = ProdutoUseCase(application)
    val produtoGetState = SingleLiveEvent<ViewState<List<Produto>>>()

    fun getAllProdutos() {
        viewModelScope.launch {
            try {
                val response = withContext(Dispatchers.IO) {
                    produtoUseCase.getAllProdutos()
                }
                produtoGetState.value = response
            } catch (ex: Exception) {
                produtoGetState.value =
                    ViewState.Error(Throwable("Não foi possível encontrar nenhum produto"))
            }
        }
    }
}