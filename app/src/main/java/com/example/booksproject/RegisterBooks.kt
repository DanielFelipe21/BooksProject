package com.example.booksproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.VolleyError
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

class RegisterBooks : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_books)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.title = "Cadastrar Livros"

        var editAuthor = findViewById<EditText>(R.id.editAuthor).text
        var editPrice = findViewById<EditText>(R.id.editPrice).text
        var editDesc = findViewById<EditText>(R.id.editDesc).text
        var btnRegisterBook: Button = findViewById(R.id.btnCadastrarL)

        btnRegisterBook.setOnClickListener {
            try {
                val queue = Volley.newRequestQueue(this)
                val url = "http://10.0.2.2:8090/livros"
                val stringRequest = object : StringRequest(Method.POST, url, { response ->
                    Log.i("Successfull_register: ", response.toString())
                    Toast.makeText(this, "Sucesso", Toast.LENGTH_SHORT).show()
                    finish()
                }, { error ->
                    Log.e("error", error.toString())
                    Toast.makeText(this, "Erro ao cadastrar", Toast.LENGTH_SHORT).show()
                }) {
                    override fun getParams(): MutableMap<String, String> {
                        val params = HashMap<String, String>()
                        var descricao = editDesc.toString()
                        var valor = editPrice.toString()
                        var autor = editAuthor.toString()
                        params["descricao"] = descricao
                        params["valor"] = valor
                        params["autor"] = autor
                        return params
                    }
                }
                queue.add(stringRequest)
            } catch (e: VolleyError) {
                Log.e("Volley_Error: ", e.message.toString())
                e.stackTrace
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {

            android.R.id.home -> {
                finish()
                true
            }

            else -> return super.onOptionsItemSelected(item)
        }
    }
}