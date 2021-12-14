package com.example.reist_app;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

public class Voos extends AppCompatActivity {


    private TextView nmId;
    private TextView nmSigla;
    private TextView nmNome;
    private ProgressBar load;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voos);


        nmId = findViewById(R.id.txtida_voo);
        nmSigla = findViewById(R.id.txtvolta_voo);
        nmNome = findViewById(R.id.txtvoo);

        load = findViewById(R.id.progressBar3);



    }


    public void onClick(View v) {
        Intent intent = new Intent(this, Confirmacao_Passagem.class);
        startActivity(intent);
    }


}