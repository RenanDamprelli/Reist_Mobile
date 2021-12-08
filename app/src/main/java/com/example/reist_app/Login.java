package com.example.reist_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.reist_app.database.DBHelper;


public class Login extends AppCompatActivity {

    DBHelper db = new DBHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }
    public void Enter(View v){
        Intent in = new Intent(Login.this, MainActivity.class);
        startActivity(in);

    }
    public void Cadastrar(View c){
        Intent cad = new Intent(this, Cadastro.class);
        startActivity(cad);
    }
}