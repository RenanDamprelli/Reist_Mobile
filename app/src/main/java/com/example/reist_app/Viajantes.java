package com.example.reist_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Viajantes extends AppCompatActivity {

    TextView txtpass;
    Button btnmais;
    Button btnmenos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viajantes);

        txtpass = findViewById(R.id.txtpass);
        btnmais = (Button)findViewById(R.id.btn_mais);
        btnmenos = (Button)findViewById(R.id.btn_menos);
    }


    public void Mais(View v) {

        int i = 1;
        txtpass.setText(String.valueOf(i+1));

    }

    public void Menos(View v) {

        int i = 1;
        txtpass.setText(String.valueOf(i-1));

    }

    public void onClick(View v) {
        Intent intent = new Intent(this, Voos.class);
        startActivity(intent);
    }
}