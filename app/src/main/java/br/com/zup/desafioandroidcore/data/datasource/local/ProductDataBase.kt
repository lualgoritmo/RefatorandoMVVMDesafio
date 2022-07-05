package br.com.zup.desafioandroidcore.data.datasource.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import br.com.zup.desafioandroidcore.data.datasource.local.dao.ProductDAO
import br.com.zup.desafioandroidcore.domain.model.Product

@Database(entities = [Product::class], version = 1)
@TypeConverters(Converters::class)
abstract class ProductDataBase : RoomDatabase() {
    abstract fun productDao(): ProductDAO

    companion object {
        @Volatile
        private var INSTANCE: ProductDataBase? = null

        fun getDatabase(context: Context): ProductDataBase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ProductDataBase::class.java,
                    "product_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}
