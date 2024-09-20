package com.example.conversaodemoedas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class Conversao extends AppCompatActivity {
    // DECLARAÇÃO DE VARIAVEIS
    TextView resultado = findViewById(R.id.txResultado);     // atrela variavel resultado ao textoResultado pela ID
    TextView valorCota = findViewById(R.id.txCotacao);       // atrela variavel valorCotação ao textoCotação pela ID
    EditText dado = findViewById(R.id.dado);                 // atrela variavel dado ao valor digitado pelo usuario
    RadioGroup opcoes = findViewById(R.id.opcoes);           // atrela variavel opçoes ao grupo de opçoes
    int opcaoSelecionada = opcoes.getCheckedRadioButtonId(); // armazena opçao selecionada pelo usiario pelo ID
    double cotaDolar = 5.48; // tentar buscar da API
    double cotaEuro = 6.11; // tentar buscar da API
    double cotaLibra = 7.25; // tentar buscar da API
    double valorConvertido = 0;  // armazena o valor convertido

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_conversao);
    }


    // METODOS CALCULOS DE CONVERSÃO
    public void converte(View view) {

        if (opcaoSelecionada == R.id.libra) {                     // se for libra
            //                converte dado buscado em texto para double e multiplica
            valorConvertido = Double.parseDouble(dado.getText().toString()) * cotaLibra;
            valorCota.setText(String.valueOf("Cotação " + cotaLibra)); // mostra valor da Cotação
            resultado.setText(String.valueOf("£ " + valorConvertido)); // mostra valor convertido

        } else if (opcaoSelecionada == R.id.dolar) {              // se for dolar
            valorConvertido = Double.parseDouble(dado.getText().toString()) * cotaDolar;
            valorCota.setText(String.valueOf("Cotação " + cotaDolar)); // mostra valor da Cotação
            resultado.setText(String.valueOf("$ " + valorConvertido)); // mostra valor convertido

        } else {                                                  // se for Euro
            valorConvertido = Double.parseDouble(dado.getText().toString()) * cotaEuro;
            valorCota.setText(String.valueOf("Cotação " + cotaEuro));  // mostra valor da Cotação
            resultado.setText(String.valueOf("€ " + valorConvertido)); // mostra valor convertido
        }

        resultado.setVisibility(View.VISIBLE); // mostrar resultado
        valorCota.setVisibility(View.VISIBLE); // mostrar cotação

    }

    // METODO LIMPA FORMULARIO RESET VALORES
    public void limpar(View view) {
        resultado.setText("");
        valorCota.setText("");
        dado.setText("");
        valorConvertido = 0;
        resultado.setVisibility(View.INVISIBLE);
        valorCota.setVisibility(View.INVISIBLE);
    }

}