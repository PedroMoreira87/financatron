package com.example.financatron

import android.content.Context
import com.example.financatron.product.Product
import com.example.financatron.product.ProductDao
import com.example.financatron.product.ProductDatabase
import com.example.financatron.user.User
import com.example.financatron.user.UserDAO
import com.example.financatron.user.UserDatabase
import kotlin.concurrent.fixedRateTimer

class DataModel private constructor() {
    lateinit var users: List<User>
    lateinit var products: List<Product>

    companion object {
        val instance = DataModel()
    }

    private lateinit var context: Context
    private lateinit var userDB: UserDAO
    private lateinit var productDB: ProductDao

    fun setContext(context: Context) {
        this.context = context
        userDB = UserDatabase.getInstance(context)?.userDao()!!
        users = userDB.getAll()
        productDB = ProductDatabase.getInstance(context)?.productDao()!!
        products = productDB.getAll()
    }

    fun addUser(user: User) {
        val id = userDB.insertAll(user)
        users = userDB.getAll()
    }

    fun getUserByName(name: String): User? {
        return users.find { name == it.name }
    }

    fun updateUser(user: User) {
        val count = userDB.updateUser(user)
        users = userDB.getAll()
    }

    fun removeUser(user: User) {
        val count = userDB.delete(user)
        users = userDB.getAll()
    }

    fun addProduct(product: Product) {
        val id = productDB.insertAll(product)
        products = productDB.getAll()
    }

    fun getAllProducts(userName: String): List<Product> {
        return productDB.getAll().filter { userName == it.userName }
    }

    fun updateProduct(product: Product) {
        val count = productDB.updateProduct(product)
        products = productDB.getAll()
    }

    fun removeProduct(product: Product) {
        val count = productDB.delete(product)
        products = productDB.getAll()
    }
}