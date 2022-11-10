package com.example.proyecto_examen_complexivo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class Navegacion extends AppCompatActivity {

    ServiciosFragment serviciosFragment=new ServiciosFragment();
    ProductosFragment productosFragment =new ProductosFragment();
    UsuarioFragment usuarioFragment=new UsuarioFragment();

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navegacion);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, usuarioFragment).commit();

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected( MenuItem item) {
                switch (item.getItemId()){
                    case R.id.menu_serivcio:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, serviciosFragment).commit();
                        return true;

                    case R.id.menu_producto:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, productosFragment).commit();
                        return true;
                    case R.id.menu_usuario:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, usuarioFragment).commit();
                        return true;
                }
                return false;
            }
        });
    }

}