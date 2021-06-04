package com.thiagodev.santander.ui

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.thiagodev.santander.R
import java.util.*
import kotlin.concurrent.schedule

class Splash : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)


        Timer().schedule(6000){
            startActivity(Intent(this@Splash, InicioActivity::class.java))
            finish()
        }

    }




}