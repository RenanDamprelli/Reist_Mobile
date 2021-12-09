package com.example.reist_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Data_Ida_Volta extends AppCompatActivity {


    Button btn_aplicar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_ida_volta);


        btn_aplicar = (Button)findViewById(R.id.btn_aplicar);

        btn_aplicar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Data_Ida_Volta.this, Viajantes.class);
                startActivity(intent);
            }
        });
    }
}