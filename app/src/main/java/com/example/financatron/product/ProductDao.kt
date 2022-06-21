package com.example.financatron.product

import androidx.room.*

@Dao
interface ProductDao {
    @Query("select * from product")
    fun getAll() : List<Product>

    @Insert
    fun insertAll(vararg city:Product)

    @Update
    fun updateProduct(city: Product):Int

    @Delete
    fun delete(city: Product):Int
}