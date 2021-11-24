package com.example.reist_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;


public class Login extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }
    public void Entrar(View v){
        Intent in = new Intent(Login.this, MainActivity.class);
        startActivity(in);

    }
    public void Cadastrar(View c){
        Intent cad = new Intent(this, Login.class);
        startActivity(cad);
        /*List<User> user = db.listAllUsers();
        for (int i = 0; i < user.size(); i++) {
            Log.d("User", ""+user.get(i));

        }*/
    }
}