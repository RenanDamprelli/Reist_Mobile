package com.example.reist_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Voos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voos);
    }


    public void onClick(View v) {
        Intent intent = new Intent(this, Confirmacao_Passagem.class);
        startActivity(intent);
    }
}