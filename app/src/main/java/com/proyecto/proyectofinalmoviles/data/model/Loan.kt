package com.proyecto.proyectofinalmoviles.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "loan_table",
foreignKeys = [ForeignKey(entity = Client::class,
    childColumns = ["client"],
    parentColumns = ["id"])])
data class Loan(
    @PrimaryKey(autoGenerate = true) val id:Int?,
    @ColumnInfo(name = "credit") val credit:Double,
    @ColumnInfo(name = "time") val time:Int,
    @ColumnInfo(name = "type") val type:Char,
    @ColumnInfo(name = "client") val client:Int,
    )
