package com.example.proyecto_examen_complexivo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class SignUp extends AppCompatActivity {

    private ImageView backView;
    private Button btnSiguiente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS,WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up1);

        backView= findViewById(R.id.btnBackView);
        backView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pantallaInicial= new Intent(SignUp.this, PantallaInicio.class);
                startActivity(pantallaInicial);
                finish();
            }
        });

        btnSiguiente= findViewById(R.id.btn_siguiente_datos_persona);
        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent navegacion= new Intent(SignUp.this, Navegacion.class);
                startActivity(navegacion);
                finish();
            }
        });
    }
}