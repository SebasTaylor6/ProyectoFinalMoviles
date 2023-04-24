package com.proyecto.proyectofinalmoviles.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class User(
    @PrimaryKey(autoGenerate = true) val id:Int?,
    @ColumnInfo(name = "username") val username:String,
    @ColumnInfo(name = "password") val password:String,
    @ColumnInfo(name = "role_id") val roleId:Int
    )
