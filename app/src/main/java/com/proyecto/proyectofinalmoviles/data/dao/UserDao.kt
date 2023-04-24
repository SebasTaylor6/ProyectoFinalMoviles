package com.proyecto.proyectofinalmoviles.data.dao

import androidx.room.*
import com.proyecto.proyectofinalmoviles.data.model.User

@Dao
interface UserDao {

    @Query("SELECT * FROM user_table")
    fun getAll(): List<User>

    @Query("SELECT * FROM user_table WHERE username=:username AND password=:password")
    fun validateLogin(username:String,password:String):User

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(user:User)

    @Delete
    suspend fun delete(user:User)

    @Query("DELETE FROM user_table")
    suspend fun deleteAll()
}