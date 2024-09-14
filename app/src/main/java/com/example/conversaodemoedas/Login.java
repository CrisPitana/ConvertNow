package com.example.conversaodemoedas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

   // intent para chamar tela conversao
    public void login(View view) {
        Intent in = new Intent(Login.this, Conversao.class);
        startActivity(in);
    }

    // intent para chamar tela cadastro
    public void cadastra(View view) {
        Intent in2 = new Intent(Login.this, CadastroActivity.class);
        startActivity(in2);
    }
}