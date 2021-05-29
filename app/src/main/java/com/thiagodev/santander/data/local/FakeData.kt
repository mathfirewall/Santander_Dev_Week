package com.thiagodev.santander.data.local

import com.thiagodev.santander.data.Cartao
import com.thiagodev.santander.data.Cliente
import com.thiagodev.santander.data.Conta

class FakeData {

    fun getLocalData(): Conta {

        val cliente = Cliente("Thiago Araújo")
        val cartao = Cartao("8222 2222 2222 2222")

        return Conta(
            "5168-1",
            "9082-2",
            "R$ 1.952,00",
            "3.500,00",
            cliente,
            cartao
        )

    }
}