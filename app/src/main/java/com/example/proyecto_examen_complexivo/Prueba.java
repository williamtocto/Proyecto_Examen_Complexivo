package com.example.proyecto_examen_complexivo;


import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class Prueba extends AppCompatActivity {
    private Button btnguardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prueba);
        btnguardar= findViewById(R.id.button3);
    }



}