package com.apdef.shopapps.storage

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.apdef.shopapps.model.Goods

@Database(entities = [Goods::class], version =  1, exportSchema = false)
abstract class GoodsRoomDatabase: RoomDatabase(){
    companion object{

        @Volatile
        private var INSTANCE: GoodsRoomDatabase? = null

        fun getDatabase(context: Context): GoodsRoomDatabase {
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    GoodsRoomDatabase::class.java,
                    "goodsDB"
                )
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
    abstract fun getGoodsDao(): GoodsDao
}