package br.com.zup.desafioandroidcore.data.datasource.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import br.com.zup.desafioandroidcore.domain.model.Produto

@Dao
interface ProdutoDAO {
    @Query("SELECT * FROM produto ORDER BY nome_produto ASC")
    fun getAllProdutos(): List<Produto>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertProduto(product:Produto)
}