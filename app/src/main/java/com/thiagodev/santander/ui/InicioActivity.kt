package com.thiagodev.santander.ui

import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.thiagodev.santander.R

class InicioActivity : AppCompatActivity(){


    val uri:Uri = Uri.parse("https://abrasuaconta.santander.com.br/landing/?ic=home-cardsprod-abrasuaconta")


    var myHandler = Handler()
    private val TIME_TO_WAIT: Long = 8000
    var myRunnable = Runnable {
        startActivity(Intent(Intent.ACTION_VIEW,uri))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio)

        val click = findViewById<TextView>(R.id.clickCliente)
        val abraConta = findViewById<ImageView>(R.id.imvAbraConta)



        abraConta.setOnClickListener {

            val builder = AlertDialog.Builder(this)
            builder.setTitle("Redirecionar para o site")
            builder.setMessage("Em 8 seg você será redirecionado para o nosso site")


            start()


            builder.setPositiveButton("Ir agora") { _: DialogInterface, _: Int ->
                startActivity(Intent(Intent.ACTION_VIEW,uri))

            }

            builder.setNegativeButton("Cancelar") { _: DialogInterface, _: Int ->
                stop()
            }




            builder.show()
        }

        click.setOnClickListener {

            startActivity(Intent(this, MenuActivity::class.java))
            finish()
        }
    }



    override fun onBackPressed() {
        finish()
    }

    fun start() {
        myHandler.postDelayed(myRunnable, TIME_TO_WAIT)
    }

    fun stop() {
        myHandler.removeCallbacks(myRunnable)
    }

    fun restart() {
        stop()
        start()
    }


}

