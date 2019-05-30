package com.matheushofstede.calculadora.Presenters

import com.matheushofstede.calculadora.Interfaces.CalculadoraPresenterInterface;
import com.matheushofstede.calculadora.Models.Calculadora
import com.matheushofstede.calculadora.Interfaces.CalculadoraViewInterface;

public class CalculadoraPresenter(view: CalculadoraViewInterface) : CalculadoraPresenterInterface {

    lateinit var view: CalculadoraViewInterface

    var equacao:String = ""

    init {
        this.view = view
        reseta()
    }


    override fun calcula() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun valida() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun recebeValor(valor: String) {
        if(equacao.length < 15){
            equacao += valor
            view.atualizaCalculo(equacao)
        }

    }

    override fun reseta() {
        equacao = ""
        view.atualizaCalculo("0")
    }

}