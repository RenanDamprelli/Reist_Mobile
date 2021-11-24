package com.example.reist_app;

import android.content.Intent;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

public class Splash extends AppCompatActivity {

    private View root;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        root = findViewById(R.id.root);



        new Handler().postDelayed(new Runnable(){
            @Override
            public void run(){
                Intent splash = new Intent(getApplicationContext(), com.example.reist_app.Login.class);
                startActivity(splash);
                finish();
            }
        },3500);
    }

}