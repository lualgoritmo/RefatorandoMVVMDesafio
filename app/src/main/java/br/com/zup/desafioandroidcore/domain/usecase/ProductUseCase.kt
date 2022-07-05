package br.com.zup.desafioandroidcore.domain.usecase

import android.app.Application
import br.com.zup.desafioandroidcore.data.datasource.local.ProductDataBase

class ProductUseCase(application: Application) {
    private val productDao = ProductDataBase
}
