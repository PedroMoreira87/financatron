package com.example.financatron.product

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Product(
    @ColumnInfo(name = "name") var name:String,
    @ColumnInfo(name = "price") var price:Float,
    @ColumnInfo(name = "day") var day:String,
    @ColumnInfo(name = "userName") var userName:String
) {
    @PrimaryKey(autoGenerate = true) var id: Int = 0
}