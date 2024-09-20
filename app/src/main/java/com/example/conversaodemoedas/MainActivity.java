package com.example.conversaodemoedas;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class MainActivity extends AppCompatActivity {

    private final int Splash_Timer = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // classe vai manipular uma execução depois do tempo estabelecido
        new Handler().postDelayed(new Runnable() {
            public void run() {

                // intent para chamar tela de login - parametro (tela atual - proxima tela)
                Intent intent = new Intent(MainActivity.this, Login.class);
                startActivity(intent); // executa intent
                finish();
            }

        }, Splash_Timer);

        // COMENTAR
    }
}
