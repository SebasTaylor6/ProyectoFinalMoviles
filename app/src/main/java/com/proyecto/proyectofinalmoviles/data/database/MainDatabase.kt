package com.proyecto.proyectofinalmoviles.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.proyecto.proyectofinalmoviles.data.dao.ClientDao
import com.proyecto.proyectofinalmoviles.data.dao.LoanDao
import com.proyecto.proyectofinalmoviles.data.dao.SavingDao
import com.proyecto.proyectofinalmoviles.data.dao.UserDao
import com.proyecto.proyectofinalmoviles.data.model.Client
import com.proyecto.proyectofinalmoviles.data.model.User
import com.proyecto.proyectofinalmoviles.data.utils.Converters

@Database(entities = [User:: class,Client::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class MainDatabase :RoomDatabase(){

    abstract fun userDao(): UserDao
    abstract fun clientDao(): ClientDao
    abstract fun loanDao(): LoanDao
    abstract fun SavingDao():SavingDao

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