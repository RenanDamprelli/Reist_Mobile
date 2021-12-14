package com.example.reist_app;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.loader.content.AsyncTaskLoader;

public class BuscarDestino extends AsyncTaskLoader<String> {
    private String mQueryString;
    BuscarDestino(Context context, String queryString) {
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
        return com.example.reist_app.Conexao.buscarDestino(mQueryString);
    }
}
