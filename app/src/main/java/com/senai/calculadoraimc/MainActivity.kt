package com.senai.calculadoraimc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.text.DecimalFormat

private lateinit var pesoEditText: EditText
private lateinit var alturaEditText: EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val calcular = findViewById<Button>(R.id.calcular)

        calcular.setOnClickListener() {

            pesoEditText = findViewById(R.id.pesoUsuario)
            alturaEditText = findViewById(R.id.alturaUsuario)

            if (validarCampos()) {
                val peso = pesoEditText.text.toString().toDouble()
                val altura = alturaEditText.text.toString().toDouble()
                val imc = DecimalFormat("#,##").format(calcularIMC(peso, altura)).toDouble()
                val resultadoIMC = String.format("Seu IMC é %s.%nStatus: %s", imc, definirEstado(imc))

            val intent = Intent(this, ResultadoActivity::class.java)
                intent.putExtra("resultado", resultadoIMC)


                startActivity(intent)

//
//                val resultadoTextView = findViewById<TextView>(R.id.resultado)
//                resultadoTextView.text =
//                    String.format("Seu IMC é %s.%nStatus: %s", imc, definirEstado(imc))
            }
        }
    }

    private fun validarCampos(): Boolean {
        var noError = true

        if (pesoEditText.text.isBlank()) {
            pesoEditText.setError("Digite um valor!!")
            noError = false
        }

        if (alturaEditText.text.isBlank()) {
            alturaEditText.setError("Digite um valor!")
            noError = false
        }

        return noError
    }
}