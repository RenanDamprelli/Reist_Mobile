package com.example.reist_app;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.loader.content.AsyncTaskLoader;

public class BuscarVoo extends AsyncTaskLoader<String> {
    private String mQueryString;
    BuscarVoo(Context context, String queryString) {
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
        return Conexao.buscarVoo(mQueryString);
    }
}
