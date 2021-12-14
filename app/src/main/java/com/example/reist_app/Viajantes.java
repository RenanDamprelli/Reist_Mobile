package com.example.reist_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Viajantes extends AppCompatActivity {

    TextView txtpass;
    Button btnmais;
    Button btnmenos;
    RadioGroup radiom;
    String classe, nome, sigla, origem, ida, volta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viajantes);

        txtpass = findViewById(R.id.txtpass);
        btnmais = (Button)findViewById(R.id.btn_mais);
        btnmenos = (Button)findViewById(R.id.btn_menos);
        radiom = findViewById(R.id.radiogroup1);

        nome = getIntent().getStringExtra("nome");
        sigla = getIntent().getStringExtra("sigla");
        origem = getIntent().getStringExtra("origem");
        ida = getIntent().getStringExtra("ida");
        volta = getIntent().getStringExtra("volta");

        radiom.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId){
                    case R.id.radioButton:
                        classe = "Classe Econômica";
                        break;

                    case R.id.radioButton3:
                        classe = "Classe Executiva";
                        break;
                }
            }
        });
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
        String pass = txtpass.getText().toString();
        Intent intent = new Intent(this, Voos.class);
        intent.putExtra("nome", nome);
        intent.putExtra("sigla", sigla);
        intent.putExtra("origem", origem);
        intent.putExtra("ida", ida);
        intent.putExtra("volta", volta);
        intent.putExtra("classe", classe);
        intent.putExtra("passageiros", pass);
        startActivity(intent);
    }
}