package com.example.conversaodemoedas;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;


public class MainActivity extends AppCompatActivity {
    // DECLARAÇÃO DE VARIAVEIS
    TextView resultado;     // atrela variavel resultado ao textoResultado pela ID
    TextView valorCota;     // atrela variavel valorCotação ao textoCotação pela ID
    EditText dado;               // atrela variavel dado ao valor digitado pelo usuario
    RadioGroup opcoes;           // atrela variavel opçoes ao grupo de opçoes
    Button botaoLimpar;
    int opcaoSelecionada; // armazena opçao selecionada pelo usiario pelo ID
    double cotaDolar = 5.48; // tentar buscar da API
    double cotaEuro = 6.11; // tentar buscar da API
    double cotaLibra = 7.25; // tentar buscar da API
    double valorConvertido = 0;  // armazena o valor convertido

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IniciarComponentes();

        //eventos ao clicar no grupo de opções
        opcoes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // se não houver digitação exibe mensagem ao usuário
                if (dado == null ){
                   Toast.makeText(MainActivity.this, "Nenhum Valor Digitado", Toast.LENGTH_SHORT).show(); // mensagem usuário
                }else{
                   // chama função para conversão
                   converte();
                }
            }
        });

       // evento ao clicar no botão limpar formulario
       botaoLimpar.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               limpar();
           }
       });

    } // FIM ONCREATE

    private void IniciarComponentes(){
        resultado = findViewById(R.id.txResultado);
        valorCota = findViewById(R.id.txCotacao);
        dado = findViewById(R.id.dado);
        opcoes = findViewById(R.id.opcoes);
        opcaoSelecionada = opcoes.getCheckedRadioButtonId();
    }


    // METODOS CALCULOS DE CONVERSÃO
    public void converte() {

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
    public void limpar() {
        resultado.setText("");
        valorCota.setText("");
        dado.setText("");
        valorConvertido = 0;
        resultado.setVisibility(View.INVISIBLE);
        valorCota.setVisibility(View.INVISIBLE);
    }

}
