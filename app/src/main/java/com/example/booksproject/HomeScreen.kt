package com.example.booksproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class HomeScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_screen)

        supportActionBar?.title = "Home"

        val extras = intent?.extras!!
        val btnB: Button = findViewById(R.id.btnListBScreen)
        val btnC: Button = findViewById(R.id.buttonListCScreen)

        btnB.setOnClickListener {
            val intent = Intent(baseContext, ScreenBooks::class.java)
            intent.putExtras(extras)
            startActivity(intent)
        }

        btnC.setOnClickListener {
            val intent = Intent(baseContext, ScreenClients::class.java)
            startActivity(intent)
        }
    }
}