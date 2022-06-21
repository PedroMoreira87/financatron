package com.example.financatron

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Total : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_total)

        val button = findViewById<Button>(R.id.btnBack)
        button.setOnClickListener {
            val intent = Intent(this, Chart::class.java)
            startActivity(intent)
        }

    }
}