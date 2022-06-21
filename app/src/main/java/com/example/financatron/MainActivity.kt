package com.example.financatron

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.financatron.user.User

class MainActivity : AppCompatActivity() {

    lateinit var userNameInput: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        DataModel.instance.setContext(this)
        userNameInput = findViewById(R.id.userName)

        val button = findViewById<Button>(R.id.btnContinue)
        button.setOnClickListener {
            val name = userNameInput.text.toString()
            val userName = DataModel.instance.getUserByName(name)

            if(userName == null) {
                DataModel.instance.addUser(
                    User(name = name)
                )
            }

            val intent = Intent(this, Chart::class.java)
            intent.putExtra("Username", name)
            startActivity(intent)
        }

    }
}