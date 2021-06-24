package com.example.booksproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import com.android.volley.Request
import com.android.volley.VolleyError
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

class RegisterClient : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_client)

        var extras = intent?.extras!!
        var token = extras.getString("token")
        supportActionBar?.title = "Cadastro Clientes"
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val editName = findViewById<EditText>(R.id.editName).text
        val editCPF = findViewById<EditText>(R.id.editCPF).text
        val editPhone = findViewById<EditText>(R.id.editPhone).text
        val editMail = findViewById<EditText>(R.id.editEmail).text
        val btnRegisterC: Button = findViewById(R.id.btnCadastrarC)

        btnRegisterC.setOnClickListener {
            try {
                val queue = Volley.newRequestQueue(this)
                val url = "http://10.0.2.2:8090/clientes"
                val stringRequest = object : StringRequest(Method.POST, url, { response ->
                    Log.i("Response: ", response.toString())
                }, { error ->
                    Log.e("Error: ", error.toString())
                }) {
                    override fun getParams(): MutableMap<String, String> {
                        val params = HashMap<String, String>()
                        var nome = editName.toString()
                        var cpf = editCPF.toString()
                        var phone = editPhone.toString()
                        var email = editMail.toString()
                        params["nome"] = nome
                        params["email"] = email
                        params["cpf"] = cpf
                        params["telefone"] = phone
                        return params
                    }

                    override fun getHeaders(): MutableMap<String, String> {
                        val params = HashMap<String, String>()
                        params["authorization"] = token.toString()
                        return params
                    }
                }
                queue.add(stringRequest)
            } catch (e: VolleyError) {
                Log.e("Volley Error: ", e.message.toString())
                e.stackTrace
            }
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                this.finish()
                true
            }

            else -> return super.onOptionsItemSelected(item)
        }
    }
}