package com.zoders.leroymerlintest.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Product::class], version = 1, exportSchema = false)
abstract class ProductDatabase: RoomDatabase() {
    abstract fun productDao(): ProductDao

    companion object {
        private const val DATABASE_NAME = "leroymerlin"

        @Volatile
        private var INSTANCE: ProductDatabase? = null

        fun getDatabase(context: Context): ProductDatabase {
            return INSTANCE ?: synchronized(this) {
                 val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ProductDatabase::class.java,
                    DATABASE_NAME
                )
                .createFromAsset("database/leroymerlin.db").build()
                INSTANCE = instance
                instance
            }
        }
    }
}


/*abstract class ProductDatabase: RoomDatabase() {
    abstract fun productDao(): ProductDao
}*/
