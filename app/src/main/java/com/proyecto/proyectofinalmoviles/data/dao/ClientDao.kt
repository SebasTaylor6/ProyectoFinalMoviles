package com.proyecto.proyectofinalmoviles.data.dao

import androidx.room.*
import com.proyecto.proyectofinalmoviles.data.model.Client
import com.proyecto.proyectofinalmoviles.data.model.User

@Dao
interface ClientDao {

    @Query("SELECT * FROM client_table")
    fun getAll(): List<Client>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(client: Client)

    @Delete
    suspend fun delete(client: Client)

    @Query("DELETE FROM client_table")
    suspend fun deleteAll()
}