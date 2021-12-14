package com.example.reist_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;



import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private AlertDialog.Builder dialogBuilder;
    private AlertDialog dialog;
    private TextView telefone, email, localizacao, result;
    String nome, cpf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (getIntent().hasExtra("nomeuser") && getIntent().hasExtra("cpfuser")){
            nome = getIntent().getStringExtra("nomeuser");
            cpf = getIntent().getStringExtra("cpfuser");
        }

        BottomNavigationView bottomNav = findViewById(R.id.nav_view);
        bottomNav.setOnNavigationItemSelectedListener(navListener);


        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                new HomeFragment()).commit();

    }


    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment fragSelecionada = null;

                    switch (item.getItemId()) {

                        case R.id.nav_explorar:
                            fragSelecionada = new HomeFragment();
                            break;

                        case R.id.nav_viagens:
                            fragSelecionada = new HomeFragment();
                            break;

                        case R.id.nav_perfil:
                            Bundle bundle = new Bundle();
                            bundle.putString("nome", nome);
                            bundle.putString("cpf", cpf);
                            fragSelecionada = new ProfileFragment();
                            fragSelecionada.setArguments(bundle);
                            break;

                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            fragSelecionada).commit();

                    return true;
                }
            };
}