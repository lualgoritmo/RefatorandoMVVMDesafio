package br.com.zup.desafioandroidcore.domain.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "Produto")
data class Product(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_produto")
    var idProduto: Long = 1,
    @ColumnInfo(name = "nome_produto")
    var nome: String,
    @ColumnInfo(name = "unidade_produto  ")
    var quantidade: Int,
    @ColumnInfo(name = "preco_produto")
    var valor: Float,
    @ColumnInfo(name = "total")
    var total: Float,
    @ColumnInfo(name = "receita")
    var receiver: String
) : Parcelable