package com.example.booksproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText

class RegisterBooks : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_books)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.title = "Cadastrar Livros"

        var editAuthor = findViewById<EditText>(R.id.editAuthor)
        var editPrice = findViewById<EditText>(R.id.editPrice)
        var editDesc = findViewById<EditText>(R.id.editDesc)
        var btnRegisterBook: Button = findViewById(R.id.btnCadastrarL)

    }

    fun postData(author: String, price: Double, desc: String) {
        val url = ""
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {

            android.R.id.home -> {
                finish()
                true
            }

            else -> return super.onOptionsItemSelected(item)
        }
    }
}