package com.example.reist_app;

import android.util.Log;

import com.example.reist_app.http.HttpClient;

import java.util.HashMap;
import java.util.Map;

public class Conexao {
    private static final String LOG_TAG = Conexao.class.getSimpleName();
    // Constantes utilizadas pela API
    // URL para a API de NBA.


    static String buscarDestino(String queryString) {
        HttpClient client = new HttpClient();
        Map<String, String> headers = new HashMap<>();
        headers.put("User-Agent","PostmanRuntime/7.28.0");
        headers.put("Accept","*/*");
        headers.put("Accept-Encoding","gzip, deflate, br");
        headers.put("Connection","keep-alive");

        String responseBody = client.doRequest("https://apireist.azurewebsites.net/Local/Buscar?nome=" + queryString, "GET", headers);
        Log.d(LOG_TAG, responseBody);
        return responseBody;
    }

    static String buscarOrigem(String queryString) {
        HttpClient client = new HttpClient();
        Map<String, String> headers = new HashMap<>();
        headers.put("User-Agent","PostmanRuntime/7.28.0");
        headers.put("Accept","*/*");
        headers.put("Accept-Encoding","gzip, deflate, br");
        headers.put("Connection","keep-alive");

        String responseBody = client.doRequest("https://apireist.azurewebsites.net/Local/Buscar?nome=" + queryString, "GET", headers);
        Log.d(LOG_TAG, responseBody);
        return responseBody;
    }


    static String buscarVoo(String queryStringv) {
        HttpClient client = new HttpClient();
        Map<String, String> headers = new HashMap<>();
        headers.put("User-Agent","PostmanRuntime/7.28.0");
        headers.put("Accept","*/*");
        headers.put("Accept-Encoding","gzip, deflate, br");
        headers.put("Connection","keep-alive");

        String responseBody = client.doRequest("https://apireist.azurewebsites.net/Passagem/BuscarIda?cidadeOrigem=Guarulhos&cidadeDestino=" + queryStringv +"&data=2022-01-01", "GET", headers);
        Log.d(LOG_TAG, responseBody);
        return responseBody;
    }
}