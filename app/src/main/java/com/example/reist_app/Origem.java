package com.example.reist_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Origem extends AppCompatActivity {


    TextView txt_origem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_origem);

        txt_origem = (TextView)findViewById(R.id.txtori);

        txt_origem.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Origem.this, Tipo_Passagem.class);
                startActivity(intent);
            }
        });
    }

}