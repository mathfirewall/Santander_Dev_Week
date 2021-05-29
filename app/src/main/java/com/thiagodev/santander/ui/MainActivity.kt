package com.thiagodev.santander.ui

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.thiagodev.santander.R
import com.thiagodev.santander.data.Conta
import java.lang.RuntimeException


class MainActivity : AppCompatActivity() {

    private lateinit var mainViewModel : MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        buscarCliente()

        //throw RuntimeException("Teste Crash")



    }

    private fun buscarCliente(){

        mainViewModel.buscarContaCliente().observe(this, Observer { result ->

            //Log.d("Angencia =>",result.numero)
            onView(result)

        })

    }

    private fun onView(conta : Conta) {
        findViewById<TextView>(R.id.tv_usuario).text = conta.cliente.nome
        findViewById<TextView>(R.id.tv_agencia).text = conta.agencia
        findViewById<TextView>(R.id.tv_conta).text = conta.numero
        findViewById<TextView>(R.id.tv_saldo).text = conta.saldo
        findViewById<TextView>(R.id.tv_saldo_valor).text = conta.limite
        val final = conta.cartao.numeroCartao.substring(conta.cartao.numeroCartao.length -3)
        findViewById<TextView>(R.id.tv_cartao_value).text = final
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        val inflate = menuInflater
        inflate.inflate(R.menu.main_menu, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when(item.itemId) {

            R.id.item_1 -> {
                Log.d("Click", "no botão")
                true
            }
            else -> super.onOptionsItemSelected(item)

        }
    }
}