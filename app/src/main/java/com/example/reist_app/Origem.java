package com.example.reist_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Origem extends AppCompatActivity {


    TextView txt_origem;
    String nome, sigla;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_origem);

        txt_origem = (TextView)findViewById(R.id.txtori);

        try {
            nome = getIntent().getStringExtra("nome");
            sigla = getIntent().getStringExtra("sigla");
        }catch(Exception e){
            Toast.makeText(this, "Erro1: " + e, Toast.LENGTH_LONG).show();
        }

        txt_origem.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String origem = txt_origem.getText().toString();
                try {
                    Intent intent = new Intent(Origem.this, Tipo_Passagem.class);
                    intent.putExtra("nome", nome);
                    intent.putExtra("sigla", sigla);
                    intent.putExtra("origem", origem);
                    startActivity(intent);
                }catch(Exception e){
                    Toast.makeText(Origem.this, "Erro2: " + e, Toast.LENGTH_LONG).show();
                }
            }
        });
    }

}