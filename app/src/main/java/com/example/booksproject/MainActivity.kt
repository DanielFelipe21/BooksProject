package com.example.booksproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.booksproject.Classes.Response
import com.example.booksproject.Classes.User
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Thread.sleep(3000)
        setTheme(R.style.Theme_BooksProject)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()

        val button: Button = findViewById(R.id.buttonLogin)
        val editUser = findViewById<EditText>(R.id.editUser).text
        val editPassword = findViewById<EditText>(R.id.editPassword).text

        button.setOnClickListener {
            val queue = Volley.newRequestQueue(this)
            val gson = Gson()
            val url = "http://10.0.2.2:8090/usuario/login"

            val stringRequest = object: StringRequest(Method.POST, url, { response ->
                var resp = gson.fromJson(response, Response::class.java)
                Log.i("API_book", response.toString())
                Toast.makeText(this, "Sucesso", Toast.LENGTH_SHORT).show()
                if(resp.status == 200) {
                    startActivity(Intent(baseContext, HomeScreen::class.java))
                }
            }, { error ->
                Log.i("API_book_error", error.toString())
                Toast.makeText(this, "A error ocurred", Toast.LENGTH_SHORT).show()
            }) {
                override fun getParams(): Map<String, String> {
                    var usuario = editUser.toString()
                    var password = editPassword.toString()
                    var user = User()
                    user.passwd = password
                    user.user = usuario
                    val params = HashMap<String, String>()
                    params["user"] = user.user
                    params["passwd"] = user.passwd
                    return params
                }
            }
            queue.add(stringRequest)
        }
    }

//        button.setOnClickListener {
//            val intent = Intent(baseContext, ScreenClients::class.java)
//            startActivity(intent)
//        }
//    }
}