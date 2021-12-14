package com.example.reist_app;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;

import com.example.reist_app.database.DBHelper;
import com.example.reist_app.models.CarregaLogin;
import com.example.reist_app.models.Usuario;

import org.json.JSONArray;
import org.json.JSONObject;


public class Login extends AppCompatActivity implements LoaderManager.LoaderCallbacks<String>{

    EditText mEmail;
    EditText mSenha;
    Button btnlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mEmail = (EditText) findViewById(R.id.txtCampoUsuario2);
        mSenha = (EditText) findViewById(R.id.txtCampoSenha2);
        btnlogin = findViewById(R.id.btnlogar3);

    }
    public void Enter(View view){
        String emailv = mEmail.getText().toString();
        String senhav = mSenha.getText().toString();
        String[] queryString = {mEmail.getText().toString(), mSenha.getText().toString()};
        InputMethodManager inputManager = (InputMethodManager)
                getSystemService(Context.INPUT_METHOD_SERVICE);
        if (inputManager != null) {
            inputManager.hideSoftInputFromWindow(view.getWindowToken(),
                    InputMethodManager.HIDE_NOT_ALWAYS);
        }

        ConnectivityManager connectivityManager = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = null;
        if (connectivityManager != null) {
            networkInfo = connectivityManager.getActiveNetworkInfo();
        }
        if (networkInfo != null && networkInfo.isConnected()) {
            Bundle queryBundle = new Bundle();
            queryBundle.putStringArray("queryString", queryString);
            getSupportLoaderManager().restartLoader(0, queryBundle, this);
            Toast.makeText(this, "Carregando...", Toast.LENGTH_SHORT).show();
        } else {
            if (emailv.isEmpty())
                Toast.makeText(this, "Email inválido", Toast.LENGTH_LONG).show();
            else {
                if (senhav.isEmpty() || mSenha.getText().toString().trim().isEmpty())
                    Toast.makeText(this, "Senha inválida", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(this, "Verifique sua conexão com a internet!", Toast.LENGTH_LONG).show();
            }
        }
    }
    public void Cadastrar(View c){
        Intent cad = new Intent(this, Cadastro.class);
        startActivity(cad);
    }

    @NonNull
    @Override
    public Loader<String> onCreateLoader(int id, @Nullable Bundle args) {
        String[] queryString = null;
        if (args != null) {
            queryString = args.getStringArray("queryString");
        }
        return new CarregaLogin(this, queryString);
    }

    @Override
    public void onLoadFinished(@NonNull Loader<String> loader, String data) {
        try {
            JSONObject jsonObject = new JSONObject(data);
            JSONObject end = jsonObject.getJSONObject("endereco");
            String nome = jsonObject.getString("nome");
            String cpf = jsonObject.getString("cpf");


            Intent intent = new Intent(Login.this, MainActivity.class);
            intent.putExtra("nomeuser", nome);
            intent.putExtra("cpfuser", cpf);
            startActivity(intent);

        } catch (Exception e) {
            Toast.makeText(this, "Email ou senha inválidos!", Toast.LENGTH_SHORT).show();
            getSupportLoaderManager().destroyLoader(0);
        }

    }

    @Override
    public void onLoaderReset(@NonNull Loader<String> loader) {

    }
}