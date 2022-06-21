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

        userNameInput = findViewById(R.id.userName)

        val button = findViewById<Button>(R.id.btnContinue)
        button.setOnClickListener {
            val intent = Intent(this, Chart::class.java)
            startActivity(intent)
        }

        findViewById<Button>(R.id.btnContinue).setOnClickListener {
            val name = userNameInput.text.toString()

            DataModel.instance.addUser(
                User(name = name)
            )
            val user2 = DataModel.instance.getUserByName(name)
            print(user2)
//            print(DataModel.instance.users)
//            userAdapter.notifyItemInserted(
//                DataModel.instance.users.size - 1
//            )
        }


    }
}