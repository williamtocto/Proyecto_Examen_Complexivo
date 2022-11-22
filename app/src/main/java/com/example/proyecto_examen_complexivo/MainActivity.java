package com.example.proyecto_examen_complexivo;


import android.content.Intent;

import android.os.Bundle;

import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.navigation.NavigationView;

import static com.example.proyecto_examen_complexivo.Registro_Persona.p;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent=new Intent(MainActivity.this,Navegacion.class);
        startActivity(intent);


        }
    }


