package com.example.proyecto_examen_complexivo;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SplashScream extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_scream);

        Animation animation1= AnimationUtils.loadAnimation(this,R.anim.desplazamiento_arriba);
        Animation animation2= AnimationUtils.loadAnimation(this,R.anim.desplazamiento_abajo);

        TextView textNombreApp= findViewById(R.id.titulo_tienda);
        TextView textSloganApp= findViewById(R.id.sub_titulo_tienda);
        ImageView logo= findViewById(R.id.logo_tienda);

        textNombreApp.setAnimation(animation2);
        textSloganApp.setAnimation(animation2);
        logo.setAnimation(animation1);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent vista_login= new Intent(SplashScream.this, PantallaInicio.class);
                startActivity(vista_login);
                finish();
            }
        },4000);

    }
}