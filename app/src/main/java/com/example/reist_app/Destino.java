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


public class Destino extends AppCompatActivity implements LoaderManager.LoaderCallbacks<String> {


    private TextView instructions;
    private EditText nmId;
    private TextView nmSigla;
    private TextView nmNome;
    private Button ButtonSave;
    private Button ButtonList;

    private ProgressBar load;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_destino);

        nmId = findViewById(R.id.txtdes);
        nmSigla = findViewById(R.id.txtsigla);
        nmNome = findViewById(R.id.txtnome);


        load = findViewById(R.id.progressBar2);

        load.setVisibility(View.GONE);

        if (getSupportLoaderManager().getLoader(0) != null) {
            getSupportLoaderManager().initLoader(0, null, this);
        }


    }

    public void OnClick(View v){

        if (nmSigla.getText().length() != 0) {
            String nomef = nmNome.getText().toString();
            String siglaf = nmSigla.getText().toString();

            Intent intent = new Intent(Destino.this, Origem.class);
            intent.putExtra("nome", nomef);
            intent.putExtra("sigla", siglaf);
            startActivity(intent);
        }else{
            nmSigla.setText("Digite um valor válido!");
        }
    }



    public void buscarDest(View view) {


        // Recupera a string de busca.
        String queryString = nmId.getText().toString();
        // esconde o teclado qdo o botão é clicado
        InputMethodManager inputManager = (InputMethodManager)
                getSystemService(Context.INPUT_METHOD_SERVICE);
        if (inputManager != null) {
            inputManager.hideSoftInputFromWindow(view.getWindowToken(),
                    InputMethodManager.HIDE_NOT_ALWAYS);
        }

        // Verifica o status da conexão de rede
        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = null;
        if (connMgr != null) {
            networkInfo = connMgr.getActiveNetworkInfo();
        }
        /* Se a rede estiver disponivel e o campo de busca não estiver vazio
         iniciar o Loader API NBA*/
        if (networkInfo != null && networkInfo.isConnected()
                && queryString.length() != 0) {
            load.setVisibility(View.VISIBLE);
            Bundle queryBundle = new Bundle();
            queryBundle.putString("queryString", queryString);
            getSupportLoaderManager().restartLoader(0, queryBundle, this);

            nmSigla.setText(R.string.loading);
            nmNome.setText("");
        }
        // atualiza a textview para informar que não há conexão ou termo de busca
        else {
            if (queryString.length() == 0) {

                nmSigla.setText(R.string.no_search_term);
            } else {

                nmSigla.setText(R.string.no_network);
            }
        }
    }


    @NonNull
    @Override
    public Loader<String> onCreateLoader(int id, @Nullable Bundle args) {
        String queryString = "";
        if (args != null) {
            queryString = args.getString("queryString");
        }
        return new BuscarDestino(this, queryString);
    }
    @Override
    public void onLoadFinished(@NonNull Loader<String> loader, String data) {
        try {
            // Converte a resposta em Json
            JSONObject jsonObject = new JSONObject(data);

            String sigla = null;
            String nome = null;
            String uf = null;

            // Procura pro resultados nos itens do array

            try {
                load.setVisibility(View.GONE);
                Thread.sleep(500);
                sigla = jsonObject.getString("sigla");
                nome = jsonObject.getString("nome");
                uf = jsonObject.getString("uf");


            } catch (JSONException e) {
                e.printStackTrace();
            }
            // move para a proxima linha

            //mostra o resultado qdo possivel.
            if (nome != null) {
                nmSigla.setText(sigla);
                nmNome.setText(nome);



                //nmLivro.setText(R.string.str_empty);
            } else {
                // If none are found, update the UI to show failed results.
                nmSigla.setText(R.string.no_results);

            }
        } catch (Exception e) {
            // Se não receber um JSOn valido, informa ao usuário
            nmSigla.setText(R.string.no_results);

            e.printStackTrace();
        }
    }
    @Override
    public void onLoaderReset(@NonNull Loader<String> loader) {
        // obrigatório implementar, nenhuma ação executada
    }

}