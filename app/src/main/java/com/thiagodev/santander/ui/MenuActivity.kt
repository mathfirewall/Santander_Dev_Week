package com.thiagodev.santander.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.cardview.widget.CardView
import com.thiagodev.santander.R

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val login = findViewById<CardView>(R.id.mcv_card_acesso_conta)

        login.setOnClickListener {

            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }



    }

    override fun onBackPressed() {
        finish()
    }
}