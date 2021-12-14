package com.example.reist_app.models;

import android.content.Context;
import android.net.Uri;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.loader.content.AsyncTaskLoader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class CarregaLogin extends AsyncTaskLoader<String> {
    private final String[] mQueryString;
    public CarregaLogin(Context context, String[] queryString) {
        super(context);
        mQueryString = queryString;
    }
    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();
    }
    @Nullable
    @Override
    public String loadInBackground() {
        return UserGetURL.buscaUser(mQueryString);
    }
}

class UserGetURL {
    private static final String LOG_TAG = UserGetURL.class.getSimpleName();
    private static final String USER_URL = "https://apireist.azurewebsites.net/Login/Login?";
    private static final String EMAIL = "email";
    private static final String SENHA = "senha";

    static String buscaUser(String[] queryString) {
        String emailurl = queryString[0];
        String senhaurl = queryString[1];

        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;
        String userJSONString = null;
        try {
            Uri builtURI = Uri.parse(USER_URL).buildUpon()
                    .appendQueryParameter(EMAIL, emailurl)
                    .appendQueryParameter(SENHA, senhaurl)
                    .build();
            URL requestURL = new URL(builtURI.toString());
            urlConnection = (HttpURLConnection) requestURL.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();
            InputStream inputStream = urlConnection.getInputStream();
            reader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder builder = new StringBuilder();
            String linha;
            while ((linha = reader.readLine()) != null) {
                builder.append(linha);
            }
            if (builder.length() == 0) {
                return null;
            }
            userJSONString = builder.toString();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (reader != null) {
                try {
                    reader.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        try {
            Log.d(LOG_TAG, userJSONString);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return userJSONString;
    }
}