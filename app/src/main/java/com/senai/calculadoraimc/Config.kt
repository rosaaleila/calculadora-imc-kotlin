package com.senai.calculadoraimc

fun calcularIMC(peso: Double, altura: Double): Double {
    return peso / (altura * altura)
}

fun definirEstado(imc: Double): String {
    return if (imc < 18.5) {
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
}
