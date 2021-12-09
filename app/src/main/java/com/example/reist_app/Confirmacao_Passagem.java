package com.example.reist_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Confirmacao_Passagem extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmacao_passagem);
    }

    public void onClick(View v) {
        Intent intent = new Intent(this, Pagamento_Passagem.class);
        startActivity(intent);
    }
}