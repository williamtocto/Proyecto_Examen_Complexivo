package com.example.proyecto_examen_complexivo;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class SignUp2 extends AppCompatActivity {
    private EditText usuario, contra, repetir;
    private Button btnregistra;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up2);
        usuario = findViewById(R.id.txt_usuario1);
        contra = findViewById(R.id.txt_contra_1);
        repetir = findViewById(R.id.txt_rep_1);
        btnregistra = findViewById(R.id.btn_registrar_1);

        btnregistra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (usuario.getText().toString().isEmpty()||contra.getText().toString().isEmpty()||repetir.getText().toString().isEmpty()){
                    Toast.makeText(SignUp2.this, "Llene todos los campos", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(SignUp2.this, "Persona Agregada", Toast.LENGTH_LONG).show();
                    Intent home = new Intent(SignUp2.this, Navegacion.class);
                    startActivity(home);
                    finish();

                }
            }
        });




    }

}