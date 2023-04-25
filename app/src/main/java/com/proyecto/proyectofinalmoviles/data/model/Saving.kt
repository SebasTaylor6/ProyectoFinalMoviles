package com.proyecto.proyectofinalmoviles.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "saving_table",
    foreignKeys = [ForeignKey(entity = Client::class,
        childColumns = ["client"],
        parentColumns = ["id"])])
data class Saving(
    @PrimaryKey(autoGenerate = true) val id:Int?,
    @ColumnInfo(name = "saving") val saving:Double,
    @ColumnInfo(name = "type") val type:String,
    @ColumnInfo(name = "client") val client:Int,
)
