package com.example.reist_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Tipo_Passagem extends AppCompatActivity {


    Button btn_idavolta;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tipo_passagem);


        btn_idavolta = (Button)findViewById(R.id.btn_idavolta);

        btn_idavolta.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Tipo_Passagem.this, Data_Ida.class);
                startActivity(intent);

                btn_idavolta.setBackground(getResources().getDrawable(R.drawable.btn_passagens_2));
            }
        });
    }
}