package com.matheushofstede.calculadora.Models

class Calculadora {
    var num1: Float = 0F
    var num2: Float = 0F
    var operacao: String = ""


    fun somar(num1: Float, num2: Float): Float {
        return num1 + num2
    }

    fun subtrair(num1: Float, num2: Float): Float {
        return num1 + num2
    }
    fun dividir(num1: Float, num2: Float): Float {
        return num1 / num2
    }
    fun multiplicar(num1: Float, num2: Float): Float {
        return num1 * num2
    }
}