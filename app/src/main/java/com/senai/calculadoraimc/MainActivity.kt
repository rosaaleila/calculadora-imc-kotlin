package com.senai.calculadoraimc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.text.DecimalFormat
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val calcular = findViewById<Button>(R.id.calcular)

        calcular.setOnClickListener() {
            val peso = findViewById<EditText>(R.id.pesoUsuario).text.toString().toDouble()
            val altura = findViewById<EditText>(R.id.alturaUsuario).text.toString().toDouble()
            val imc = DecimalFormat("#,##0.00").format(peso / (altura * altura)).toString().toDouble()

            val imcStatus = if (imc < 18.5) {
                "Abaixo do peso."
            } else if (imc in 18.5..24.9) {
                "Peso normal."
            } else if (imc >= 25 && imc < 29.9) {
                "Sobrepeso."
            } else if (imc >= 30 && imc < 34.9) {
                "Obesidade Grau I."
            } else if (imc >= 35 && imc < 40) {
                "Obesidade Grau II."
            } else {
                "Obesidade Grau III ou Mórbida. Cuidado!"
            }

            val textoResultado = findViewById<TextView>(R.id.resultado)
            textoResultado.text = String.format("Seu IMC é %s.%nStatus: %s", imc, imcStatus)

        }

    }
}