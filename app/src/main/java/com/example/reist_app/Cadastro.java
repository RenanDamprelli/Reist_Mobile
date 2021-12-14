package com.example.reist_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class Cadastro extends AppCompatActivity {

    EditText mNome, mCpf, mEmail, mCelular, mSexo, mData, mCep, mEstado, mCidade, mBairro, mLog
            , mNum, mSenha, mConfSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        mNome = (EditText) findViewById(R.id.txtnomecad);
        mCpf = (EditText) findViewById(R.id.txtcpfcad);
        mEmail = (EditText) findViewById(R.id.txtemail);
        mCelular = (EditText) findViewById(R.id.txtcellcad);
        mSexo = (EditText) findViewById(R.id.txtsexocad);
        mData = (EditText) findViewById(R.id.txtnascimentocad);
        mCep = (EditText) findViewById(R.id.txtcepcad);
        mEstado = (EditText) findViewById(R.id.txtestadocad);
        mCidade = (EditText) findViewById(R.id.txtcidadecad);
        mBairro = (EditText) findViewById(R.id.txtbairrocad);
        mLog = (EditText) findViewById(R.id.txtlogradourocad);
        mNum = (EditText) findViewById(R.id.txtnumerocad);
        mSenha = (EditText) findViewById(R.id.txtsenhacad);
        mConfSenha = (EditText) findViewById(R.id.txtconfirmacad);
    }

    public void cadastraUser(View view){
        if (mNome.getText().toString().trim().isEmpty() ||
                mCpf.getText().toString().trim().isEmpty() ||
                mEmail.getText().toString().trim().isEmpty() ||
                mCelular.getText().toString().trim().isEmpty() ||
                mSexo.getText().toString().trim().isEmpty() ||
                mData.getText().toString().trim().isEmpty() ||
                mCep.getText().toString().trim().isEmpty() ||
                mEstado.getText().toString().trim().isEmpty() ||
                mCidade.getText().toString().trim().isEmpty() ||
                mBairro.getText().toString().trim().isEmpty() ||
                mLog.getText().toString().trim().isEmpty() ||
                mNum.getText().toString().trim().isEmpty() ||
                mSenha.getText().toString().trim().isEmpty() ||
                mConfSenha.getText().toString().trim().isEmpty()){
            Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_LONG).show();
        }
        else {
            if (!(mSenha.getText().toString().equals(mConfSenha.getText().toString()))){
                Toast.makeText(this, "Senhas diferentes!", Toast.LENGTH_LONG).show();
            }
            else {
                String[] dados = {mNome.getText().toString(),
                        mCpf.getText().toString(),
                        mEmail.getText().toString(),
                        mCelular.getText().toString(),
                        mSexo.getText().toString(),
                        mData.getText().toString(),
                        mCep.getText().toString(),
                        mEstado.getText().toString(),
                        mCidade.getText().toString(),
                        mBairro.getText().toString(),
                        mLog.getText().toString(),
                        mNum.getText().toString(),
                        mSenha.getText().toString()};
                new HTTPReqTask().execute(dados);
            }
        }
    }

    private class HTTPReqTask extends AsyncTask<String, Void, Void> {

        @Override
        protected void onPreExecute() {
            Toast.makeText(Cadastro.this, "Carregando...", Toast.LENGTH_LONG).show();
        }

        @Override
        protected Void doInBackground(String... params) {
            HttpURLConnection urlConnection = null;
            String nome, cpf, email, cell, sexo, data, cep, estado, cidade, bairro,
                    logradouro, numero, senha;
            nome = params[0];
            cpf = params[1];
            email = params[2];
            cell = params[3];
            sexo = params[4];
            data = params[5];
            cep = params[6];
            estado = params[7];
            cidade = params[8];
            bairro = params[9];
            logradouro = params[10];
            numero = params[11];
            senha = params[12];
            int numerof = Integer.parseInt(numero);
            try {
                JSONObject postBody = new JSONObject();
                postBody.put("cpf", cpf);
                postBody.put("nome", nome);
                postBody.put("email", email);
                postBody.put("senha", senha);
                postBody.put("celular", cell);
                postBody.put("sexo", sexo);
                postBody.put("nascimento", data);
                JSONObject end = new JSONObject();
                end.put("cep", cep);
                end.put("uf", estado);
                end.put("cidade", cidade);
                end.put("bairro", bairro);
                end.put("logradouro", logradouro);
                end.put("numero", numerof);
                postBody.put("endereco", end);

                Log.d("Cadastro", String.valueOf(postBody));

                URL url = new URL("https://apireist.azurewebsites.net//Cliente/Cadastrar");
                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestProperty("Content-Type", "application/json");
                urlConnection.setRequestMethod("POST");
                urlConnection.setDoOutput(true);
                urlConnection.setDoInput(true);
                urlConnection.setChunkedStreamingMode(0);

                OutputStreamWriter wr= new OutputStreamWriter(urlConnection.getOutputStream());
                wr.write(postBody.toString());
                wr.flush();

                int code = urlConnection.getResponseCode();
                if (code !=  201) {
                    throw new IOException("Resposta inválida: " + code);
                }

                BufferedReader rd = new BufferedReader(new InputStreamReader(
                        urlConnection.getInputStream()));
                String line;
                while ((line = rd.readLine()) != null) {
                    Log.i("data", line);
                }
            } catch (Exception e) {
                e.printStackTrace();
                try {
                    Toast.makeText(Cadastro.this, "Algum erro aconteceu! " + e, Toast.LENGTH_LONG).show();
                }catch (Exception exception){
                    e.printStackTrace();
                }
            } finally {
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void unused) {
            Toast.makeText(Cadastro.this, "Cadastro concluído!", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(Cadastro.this, Login.class);
            startActivity(intent);
            finish();
        }
    }
}