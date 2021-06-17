package com.example.booksproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.booksproject.Classes.User
import com.google.gson.Gson
import org.w3c.dom.Text
import java.lang.Error

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Thread.sleep(3000)
        setTheme(R.style.Theme_BooksProject)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()

        val button: Button = findViewById(R.id.buttonLogin)
        val editUser: EditText = findViewById(R.id.editUser)
        val editPassword: EditText = findViewById(R.id.editPassword)
        val textCadastro = findViewById<TextView>(R.id.textRegister)
        val usuario = editUser.text.toString()
        val password = editPassword.text.toString()

        button.setOnClickListener {
            val queue = Volley.newRequestQueue(this)
            val gson = Gson()
            val url = "http://10.0.2.2:8090/usuario/login"
            //val url = ""
            var user = User()
            val stringRequest = StringRequest(Request.Method.POST, url, { response ->
                user.passwd = password
                user.user = usuario;
                gson.toJson(user)
                Log.i("API_book", response.toString())
                val resp = gson.fromJson(response, User::class.java)
            }, { error ->
                Log.i("API_book_error", error.toString())
            })
            queue.add(stringRequest)
        }

        textCadastro.setOnClickListener{
            val intent = Intent(baseContext, RegisterScreen::class.java)
            startActivity(intent)
        }
    }
}