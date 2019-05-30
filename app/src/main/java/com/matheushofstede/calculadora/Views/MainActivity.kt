package com.matheushofstede.calculadora.Views

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.view.View
import com.matheushofstede.calculadora.Interfaces.CalculadoraPresenterInterface
import com.matheushofstede.calculadora.Interfaces.CalculadoraViewInterface
import com.matheushofstede.calculadora.Presenters.CalculadoraPresenter
import com.matheushofstede.calculadora.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), CalculadoraViewInterface {

    lateinit var presenter: CalculadoraPresenterInterface

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        formula.text = "0"
        resultado.text = "0"

        presenter = CalculadoraPresenter(this)

        //On click listeners

        //numeros

        btn_num_0.setOnClickListener{
            presenter.recebeValor(btn_num_0.text.toString())
        }
        btn_num_1.setOnClickListener{
            presenter.recebeValor(btn_num_1.text.toString())
        }
        btn_num_2.setOnClickListener{
            presenter.recebeValor(btn_num_2.text.toString())
        }
        btn_num_3.setOnClickListener{
            presenter.recebeValor(btn_num_3.text.toString())
        }
        btn_num_4.setOnClickListener{
            presenter.recebeValor(btn_num_4.text.toString())
        }
        btn_num_5.setOnClickListener{
            presenter.recebeValor(btn_num_5.text.toString())
        }
        btn_num_6.setOnClickListener{
            presenter.recebeValor(btn_num_6.text.toString())
        }
        btn_num_7.setOnClickListener{
            presenter.recebeValor(btn_num_7.text.toString())
        }
        btn_num_8.setOnClickListener{
            presenter.recebeValor(btn_num_8.text.toString())
        }
        btn_num_9.setOnClickListener{
            presenter.recebeValor(btn_num_9.text.toString())
        }

        //operacoes

        btn_dividir.setOnClickListener{
            presenter.recebeValor(btn_dividir.text.toString())
        }
        btn_multiplicar.setOnClickListener{
            presenter.recebeValor(btn_multiplicar.text.toString())
        }
        btn_subtrair.setOnClickListener{
            presenter.recebeValor(btn_subtrair.text.toString())
        }
        btn_somar.setOnClickListener{
            presenter.recebeValor(btn_somar.text.toString())
        }

        // outros

        btn_ponto.setOnClickListener{
            presenter.recebeValor(btn_ponto.text.toString())
        }
        btn_calcular.setOnClickListener{
            presenter.calcula()
        }
        btn_corrigir.setOnClickListener{
            presenter.removeDigito()
        }
        btn_corrigir.setOnLongClickListener {
            presenter.resetaTudo()
            return@setOnLongClickListener true
        }

    }


    override fun exibeResultado(valor: String) {
        resultado.text = valor
    }

    override fun atualizaCalculo(valor: String) {
        formula.text = valor
    }

    override fun exibeDialogo() {
        AlertDialog.Builder(this)
            .setTitle("Algo de errado não está certo!")
            .setPositiveButton("talquei") { _,_ -> }
            .setMessage("Por favor, digite uma operação válida")
            .show()
    }
}
