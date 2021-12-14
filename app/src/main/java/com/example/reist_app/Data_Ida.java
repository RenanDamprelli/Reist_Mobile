package com.example.reist_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;

public class Data_Ida extends AppCompatActivity {


    Button btn_aplicar;
    CalendarView calendar;
    TextView ida;
    TextView volta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_ida);

        calendar = (CalendarView)findViewById(R.id.calendar);
        ida = findViewById(R.id.txtida);
        btn_aplicar = (Button)findViewById(R.id.btn_aplicar);

        String nome = getIntent().getStringExtra("nome");
        String sigla = getIntent().getStringExtra("sigla");
        String origem = getIntent().getStringExtra("origem");

        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {

            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                String date = dayOfMonth + "/" + month + "/" + year;
                ida.setText(date);
            }

        });

        btn_aplicar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String idaf = ida.getText().toString();
                Intent intent = new Intent(Data_Ida.this, Data_Volta.class);
                intent.putExtra("nome", nome);
                intent.putExtra("sigla", sigla);
                intent.putExtra("origem", origem);
                intent.putExtra("ida", idaf);
                startActivity(intent);
            }
        });


    }
}