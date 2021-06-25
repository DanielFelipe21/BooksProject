package com.example.booksproject

import android.content.Intent
import android.content.Intent.getIntent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem

class ScreenClients : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_screen_clients)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.title = "Clientes"
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_plus, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        var extras = intent?.extras!!
//        var token = extras.getString("token")
        return when (item.itemId) {

            android.R.id.home -> {
                finish()
                true
            }

            R.id.btn_plus -> {
                val intent = Intent(baseContext, RegisterClient::class.java)
//                val bundle = Bundle()
//                bundle.putString("token", token)
//                intent.putExtras(bundle)
                startActivity(intent)
                true
            }

            else -> return super.onOptionsItemSelected(item)
        }
    }
}