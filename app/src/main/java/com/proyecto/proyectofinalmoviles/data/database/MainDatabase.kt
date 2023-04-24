package com.proyecto.proyectofinalmoviles.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.proyecto.proyectofinalmoviles.data.dao.UserDao
import com.proyecto.proyectofinalmoviles.data.model.User

@Database(entities = [User:: class], version = 1, exportSchema = false)
abstract class MainDatabase :RoomDatabase(){

    abstract fun userDao(): UserDao

    companion object{

        @Volatile
        private var INSTANCE :MainDatabase? = null

        fun getDatabase(context: Context):MainDatabase{
            val tempInstance = INSTANCE
            if (tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MainDatabase::class.java,
                    "moviles_db"
                ).allowMainThreadQueries().build()
                INSTANCE = instance
                return instance
            }
        }
    }
}