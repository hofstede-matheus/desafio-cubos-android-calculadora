package com.matheushofstede.calculadora.Presenters

import android.util.Log
import com.matheushofstede.calculadora.Interfaces.CalculadoraPresenterInterface
import com.matheushofstede.calculadora.Models.Calculadora
import com.matheushofstede.calculadora.Interfaces.CalculadoraViewInterface

class CalculadoraPresenter(view: CalculadoraViewInterface) : CalculadoraPresenterInterface {

    var view: CalculadoraViewInterface = view

    var equacao: String
    var num1: String
    var num2: String
    var operacao: Char
    var resultado: Float
    var calculadora: Calculadora

    init {
        equacao = ""
        num1 = ""
        num2 = ""
        operacao = '\u0000' // o Android Studio me obrigou a colocar isso aqui
        resultado = 0F
        calculadora = Calculadora()
    }

    override fun calcula() {
        if(isValida()){

            /*
            Log.e("NUM1", num1)
            Log.e("NUM2", num2)
            Log.e("OP", operacao.toString())
            */

            // decide qual operacao faz
            when(operacao){
                '+' -> resultado = calculadora.somar(num1.toFloat(), num2.toFloat())
                '-' -> resultado = calculadora.subtrair(num1.toFloat(), num2.toFloat())
                '÷' -> resultado = calculadora.dividir(num1.toFloat(), num2.toFloat())
                '*' -> resultado = calculadora.multiplicar(num1.toFloat(), num2.toFloat())
            }

            //Log.e("R", resultado.toString())

            var resultadoString = resultado.toString()

            // Isso aqui é pra caso seja xxxx.0 (um inteiro, mas com o formato de float), remova esses 2 ultimos chars. É pra ficar mais bonitinho mesmo
            if(resultadoString.substring(resultadoString.length - 2) == ".0") resultadoString = resultadoString.dropLast(2)

            view.exibeResultado(resultadoString)
            view.atualizaCalculo("0")
            equacao = "0"
        }else{
            view.exibeDialogo()
        }
        num1 = ""
        num2 = ""
        operacao = '\u0000'
    }

    override fun isValida(): Boolean {
        var achouOperacao = false // pra verificar se é a única operação da equação
        var posicao = 0

        while (posicao < equacao.length){
            //Log.e("NUM", "$posicao ::: ${equacao[posicao]}")

            /*
            Aqui eu estou quebrando a validacao em 3 partes:
            1. Compoe num1
            2. Acha a operacao e guarda ela
            3. Compoe num2
            */

            // checando se a "array das operações" contem determinado char, ou seja, se o char atual é uma operação, não um numero ou um ponto
            // não sei se é gambiarra, mas foi o jeito mais elegante que achei
            if("+-÷*".contains(equacao[posicao])){

                // se ele achou a operacao antes, é pq tem mais de uma operação, logo a equação é inválida
                if(achouOperacao) return false

                operacao = equacao[posicao]
                achouOperacao = true

                // se achou a operacao na primeira posicao ou na ultima, o formato está errado, logo a equação é inválida
                if(posicao == 0 || posicao == equacao.length - 1) return false
            }

            // compoe strings
            if (operacao == '\u0000') num1 += equacao[posicao]  // verifica se é a primeira parte e compoe num1
            else if( !("+-÷*".contains(equacao[posicao]))) num2 += equacao[posicao] // compoe num2, mas apenas se o char atual não for uma operação

            posicao++
        }
        // opa, divisão por zero
        if(num2.toFloat() == 0F) return false

        return true
    }

    override fun recebeValor(valor: String) {
        if(equacao.length < 15){
            equacao += valor
            view.atualizaCalculo(equacao)
        }

    }

    override fun removeDigito() {
        equacao = equacao.dropLast(1)
        view.atualizaCalculo(equacao)
    }

    override fun resetaTudo() {
        equacao = ""
        num1 = ""
        num2 = ""
        operacao = '\u0000' // o Android Studio me obrigou a colocar isso aqui
        resultado = 0F
        view.exibeResultado("0")
    }

}