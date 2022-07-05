package br.com.zup.desafioandroidcore.data.datasource.local

import androidx.room.TypeConverter
import br.com.zup.desafioandroidcore.domain.model.Product
import com.google.gson.Gson

class Converters {
    @TypeConverter
    fun converterFromProduct(value: String): Product?{
        return Gson().fromJson(value, Product::class.java)
    }

    @TypeConverter
    fun converterToJson(director: Product): String{
        return Gson().toJson(director)
    }
}