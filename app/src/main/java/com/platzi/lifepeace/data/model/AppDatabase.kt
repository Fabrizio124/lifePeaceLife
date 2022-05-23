package com.platzi.lifepeace.data.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database (entities = arrayOf(TextoFav::class),version = 1)
abstract class AppDatabase :RoomDatabase() {

       abstract fun textDao(): TextDao
       companion object{
           private var INSTANCE: AppDatabase? = null

           fun getDatabase(context: Context): AppDatabase {
               INSTANCE = INSTANCE ?: Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, "tabla_textos").build()
           return INSTANCE!!
       }
           fun destroyInstance(){
               INSTANCE = null
           }

    }
}