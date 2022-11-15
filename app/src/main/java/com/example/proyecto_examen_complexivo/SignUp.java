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


    }
}