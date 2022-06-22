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
//                val user = DataModel.instance.users[position]
//                user.name = "Nome Deletado!"
//                DataModel.instance.updateUser(user)
//                productAdapter.notifyItemChanged(position)
            }

            override fun onItemLongClicked(view: View, position: Int) {
//                DataModel.instance.removeUser(
//                    DataModel.instance.users[position]
//                )
//                productAdapter.notifyItemRemoved(position)
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