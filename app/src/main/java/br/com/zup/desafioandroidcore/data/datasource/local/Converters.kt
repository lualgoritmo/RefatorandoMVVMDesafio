package br.com.zup.desafioandroidcore.data.datasource.local

import androidx.room.TypeConverter
import br.com.zup.desafioandroidcore.domain.model.Produto
import com.google.gson.Gson

class Converters {
    @TypeConverter
    fun converterFromProduct(value: String): Produto?{
        return Gson().fromJson(value, Produto::class.java)
    }

    @TypeConverter
    fun converterToJson(director: Produto): String{
        return Gson().toJson(director)
    }
}