package com.example.proyecto_examen_complexivo;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import com.example.proyecto_examen_complexivo.datos_sqlite.CargarUsuario;

public class SplashScream extends AppCompatActivity {



    public static TextView nombreUser;
    LinearLayout linearLayout;
    TextView nombre_user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_scream);

        TextView txtName = (TextView) findViewById(R.id.nombre_usuario);
        System.out.println(txtName);
        Animation animation1 = AnimationUtils.loadAnimation(this, R.anim.desplazamiento_arriba);
        Animation animation2 = AnimationUtils.loadAnimation(this, R.anim.desplazamiento_abajo);
        TextView textNombreApp = findViewById(R.id.titulo_tienda);
        ImageView logo = findViewById(R.id.logo_tienda);
        textNombreApp.setAnimation(animation2);
        logo.setAnimation(animation1);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                CargarUsuario usu = new CargarUsuario(SplashScream.this);
                /*IF PARA EVITAR QUE EL STRING SEA NULO SI NO HAY DATOS REGISTRADOS EN LA BDD TEMPORAL*/
                if (usu.listarUsuarioP() == null) {
                    System.out.println("AAAAAAAAAAAAAAAAAAAAAAA");
                    Intent vista_login = new Intent(SplashScream.this, PantallaInicio.class);
                    startActivity(vista_login);
                    finish();
                } else {
                    //AGREGAR NOMBRE USUARIO
                    System.out.println(usu.listarUsuarioP().get(0).getIdpersona().getNombre());
                    // Registro_Usuario.nombreUser.setText(usu.listarUsuarioP().get(0).getIdpersona().getNombre()+" " +usu.listarUsuarioP().get(0).getIdpersona().getApellido());
                    System.out.println("BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB");
                    Intent vista_login = new Intent(SplashScream.this, MainActivity.class);
                    startActivity(vista_login);
                    finish();
                }

            }
        }, 4000);

    }



}