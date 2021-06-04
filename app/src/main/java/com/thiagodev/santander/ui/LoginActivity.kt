package com.thiagodev.santander.ui

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.thiagodev.santander.MaskCpf
import com.thiagodev.santander.R

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        val backmenu = findViewById<ImageView>(R.id.login_back)
        val select = findViewById<Switch>(R.id.select)
        val cpf = findViewById<EditText>(R.id.editCPF)
        val alert = findViewById<FrameLayout>(R.id.alertDialog)

        cpf.addTextChangedListener(MaskCpf.insert(cpf))

        val cpff: TextWatcher = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                if (count == 14) {

                    if (cpf.text.toString() == "122.225.652-00"){

                        startActivity(Intent(this@LoginActivity, MainActivity::class.java))
                        finish()

                    }else {
                        val builder = AlertDialog.Builder(this@LoginActivity)
                        builder.setTitle("Atemção")
                        builder.setMessage("CPF Inválido")
                        //builder.setPositiveButton("ok") { _: DialogInterface, _: Int -> }

                        builder.setNegativeButton("OK") { _: DialogInterface, _: Int -> }
                        builder.show()

                    }

                }

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {

            }

        }
        cpf.addTextChangedListener(cpff)





        select.setOnCheckedChangeListener { buttonView, isChecked ->


            if (isChecked) {
                select.setTrackResource(R.color.redPrimary)

            }else {
                select.setTrackResource(R.color.teal_200)
            }


        }

        backmenu.setOnClickListener {
            startActivity(Intent(this, MenuActivity::class.java))
            finish()
        }
    }



    override fun onBackPressed() {
        startActivity(Intent(this, MenuActivity::class.java))
        finish()
    }
}