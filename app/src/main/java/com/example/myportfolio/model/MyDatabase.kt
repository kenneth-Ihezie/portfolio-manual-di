package com.example.myportfolio.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.coroutines.CoroutineScope

@Database(entities = [Portfolio::class], version = 1, exportSchema = false)
abstract class MyDatabase : RoomDatabase() {
    abstract fun portfolioDao(): PortfolioDao
    companion object{
        @Volatile
        private var INSTANCE: MyDatabase? = null
        fun getDatabase(context: Context, scope: CoroutineScope): MyDatabase{
            return INSTANCE?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MyDatabase::class.java,
                    "portfolio_database"
                ).build()
                INSTANCE=instance
                instance
            }
        }
    }

}