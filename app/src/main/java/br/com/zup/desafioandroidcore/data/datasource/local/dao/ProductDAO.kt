package br.com.zup.desafioandroidcore.data.datasource.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import br.com.zup.desafioandroidcore.domain.model.Product

@Dao
interface ProductDAO {
    @Query("SELECT * FROM produto ORDER BY nome_produto ASC")
    fun getAllProducts():List<Product>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertProduct(product: Product)
}