package com.example.financatron.user

import androidx.room.*

@Dao
interface UserDAO {
    @Query("select * from user")
    fun getAll() : List<User>

    @Insert
    fun insertAll(vararg user:User)

    @Update
    fun updateUser(user: User):Int

    @Delete
    fun delete(user: User):Int
}