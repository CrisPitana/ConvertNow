package com.example.conversaodemoedas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Login extends AppCompatActivity {
    Button buttonEntrar, buttonCadastro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        buttonEntrar=findViewById(R.id.btnEntrar);
        buttonCadastro=findViewById(R.id.btncadastra);

        buttonEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(Login.this, Conversao.class);
                startActivity(in);
            }
        });

        buttonCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(Login.this, CadastroActivity.class);
                startActivity(in);
            }
        });

    }

}




/*
   // intent para chamar tela conversao
    public void entrar(View view) {
        Intent in = new Intent(Login.this, Conversao.class);
        startActivity(in);
    }

    // intent para chamar tela cadastro
    public void cadastra(View view) {
        Intent in2 = new Intent(Login.this, CadastroActivity.class);
        startActivity(in2);
    }


 */