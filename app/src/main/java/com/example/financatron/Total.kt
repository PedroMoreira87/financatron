package com.example.financatron

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.financatron.product.ProductAdapter

class Total : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var userName: String
    lateinit var productAdapter: ProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_total)
        userName = intent.getStringExtra("Username").toString()

        recyclerView = findViewById(R.id.recyclerView)
        productAdapter = ProductAdapter(userName, clickListener = object : OnClickedListener {
            override fun onItemClicked(view: View, position: Int) {
                DataModel.instance.removeProduct(DataModel.instance.getAllProducts(userName)[position])
                productAdapter.notifyItemRemoved(position)
            }

            override fun onItemLongClicked(view: View, position: Int) {
                TODO("Not yet implemented")
            }

        })
        recyclerView.adapter = productAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        userName = intent.getStringExtra("Username").toString()

        val button = findViewById<Button>(R.id.btnBack)
        button.setOnClickListener {
            val intent = Intent(this, Chart::class.java)
            intent.putExtra("Username", userName)
            startActivity(intent)
        }

    }
}