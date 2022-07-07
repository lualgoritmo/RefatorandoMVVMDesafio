package br.com.zup.desafioandroidcore.data.datasource.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import br.com.zup.desafioandroidcore.data.datasource.local.dao.ProdutoDAO
import br.com.zup.desafioandroidcore.domain.model.Produto

@Database(entities = [Produto::class], version = 1)
@TypeConverters(Converters::class)
abstract class ProdutoDataBase : RoomDatabase() {
    abstract fun produtoDao(): ProdutoDAO

    companion object {
        @Volatile
        private var INSTANCE: ProdutoDataBase? = null

        fun getDatabase(context: Context): ProdutoDataBase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ProdutoDataBase::class.java,
                    "filme_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}
