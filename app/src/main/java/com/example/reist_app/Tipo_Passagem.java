package com.example.reist_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Tipo_Passagem extends AppCompatActivity {


    Button btn_idavolta;
    String nome2, sigla2, origem2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tipo_passagem);

        try {
            nome2 = getIntent().getStringExtra("nome");
            sigla2 = getIntent().getStringExtra("sigla");
            origem2 = getIntent().getStringExtra("origem");
        }catch(Exception e){
            Toast.makeText(this, "Erro3: " + e, Toast.LENGTH_LONG).show();
        }


        btn_idavolta = (Button)findViewById(R.id.btn_idavolta);

        btn_idavolta.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(Tipo_Passagem.this, Data_Ida.class);
                    intent.putExtra("nome", nome2);
                    intent.putExtra("sigla", sigla2);
                    intent.putExtra("origem", origem2);
                    startActivity(intent);

                    //btn_idavolta.setBackground(getResources().getDrawable(R.drawable.btn_passagens_2));
                }catch(Exception e){
                    Toast.makeText(Tipo_Passagem.this, "Erro4: " + e, Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}