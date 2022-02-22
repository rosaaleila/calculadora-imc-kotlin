package com.senai.calculadoraimc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ResultadoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        val resultado = findViewById<TextView>(R.id.resultado)

        val intent: Intent = getIntent()

        resultado.text = intent.getStringExtra("resultado")

    }
}