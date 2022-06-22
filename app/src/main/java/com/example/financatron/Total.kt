package com.example.financatron

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Total : AppCompatActivity() {

    private lateinit var userName : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_total)

        userName = intent.getStringExtra("Username").toString()

        val button = findViewById<Button>(R.id.btnBack)
        button.setOnClickListener {
            val intent = Intent(this, Chart::class.java)
            intent.putExtra("Username", userName)
            startActivity(intent)
        }

    }
}