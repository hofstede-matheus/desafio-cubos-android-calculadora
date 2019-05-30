package com.matheushofstede.calculadora.Interfaces

interface CalculadoraPresenterInterface {
    fun calcula()
    fun isValida(): Boolean
    fun recebeValor(valor: String)
    fun resetaTudo()
    fun removeDigito()

}