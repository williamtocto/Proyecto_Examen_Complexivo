package com.example.proyecto_examen_complexivo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.proyecto_examen_complexivo.adapter.LoginAdapter;
import com.example.proyecto_examen_complexivo.modelo.Persona;
import com.example.proyecto_examen_complexivo.service.Apis;
import com.example.proyecto_examen_complexivo.service.PersonaService;
import com.example.proyecto_examen_complexivo.service.UsuarioService;
import com.example.proyecto_examen_complexivo.modelo.Usuario;
import com.example.proyecto_examen_complexivo.service.Validacion_user;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonObject;
import com.squareup.picasso.Picasso;
import okhttp3.OkHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class Inicio_Login extends AppCompatActivity implements Validacion_user {

    public static ArrayList<Usuario> arrayDatos = new ArrayList<Usuario>();

    private ProgressBar progressBar;
    private Button btn_ingresa;
    private TextView txtUsuario, txtClave;

    private static final String BASE_URL = "http://localhost:8080/api/usuario/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btn_ingresa = findViewById(R.id.btn_ingresar);
        txtUsuario = findViewById(R.id.txt_usuario);
        txtClave = findViewById(R.id.txt_contraseña);
        progressBar = findViewById(R.id.progressBar);

        btn_ingresa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Usuario u = new Usuario();
                u.setUsu_contrasena(txtClave.getText().toString());
                u.setUsuusuario(txtUsuario.getText().toString());
                enviar_datos_login(u);
                new LoginAdapter(Inicio_Login.this).execute(txtUsuario.getText(), txtClave.getText(), 3000);
            }
        });
    }


    public void enviar_datos_login(Usuario user) {


        UsuarioService usuarioService = Apis.getUsuarioService();
        Call<List<Usuario>> call = usuarioService.addUsuario(user);

        call.enqueue(new Callback<List<Usuario>>() {
            @Override
            public void onResponse(Call<List<Usuario>> call, retrofit2.Response<List<Usuario>> response) {
                System.out.println(response.body()+ " ssssssssssssssssssssoooooooooooooooooooooooooooooooooo");

                if (response.isSuccessful()) {
                    System.out.println("ssssssssssssss");
                    Toast.makeText(Inicio_Login.this, "Datos Guardados", Toast.LENGTH_LONG).show();
                } else {
                }
            }
            @Override
            public void onFailure(Call<List<Usuario>> call, Throwable t) {
                System.out.println(       t.getMessage());

                Toast.makeText(Inicio_Login.this, "Error al agregar usuario", Toast.LENGTH_SHORT).show();
            }
        });

    }

/*
    private void enviarDatos() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        UsuarioService json = retrofit.create(UsuarioService.class);

        JSONObject jsonObject = new JSONObject();
        Call<List<Usuario>> call = json.getPosts();
        call.enqueue(new Callback<List<Usuario>>() {
            @Override
            public void onResponse(Call<List<Usuario>> call, retrofit2.Response<List<Usuario>> response) {
                List<Usuario> post = response.body();
                try {
                    for (Usuario u : post) {
                        u.getUsuusuario();
                        u.getUsuusuario();
                        arrayDatos.add(u);
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            @Override
            public void onFailure(Call<List<Usuario>> call, Throwable t) {
                System.out.println(t.fillInStackTrace());
                System.out.println(t.getMessage());
            }
        });
    }
*/

    private void pasarJson(JsonArray array) {

        for (int i = 0; i < array.size(); i++) {
            //  arrayDatos.add(post);

        }

    }

    @Override
    public void toggleProgressBar(boolean status) {
        if (status) {
            progressBar.setVisibility(View.VISIBLE);
        } else {
            progressBar.setVisibility(View.GONE);
        }
    }

    @Override
    public void lanzarActividad(Class<?> tipoActividad) {
        Intent intent = new Intent(this, tipoActividad);
        startActivity(intent);
    }

    @Override
    public void showMessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();

    }
}