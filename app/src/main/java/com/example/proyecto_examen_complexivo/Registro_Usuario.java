package com.example.proyecto_examen_complexivo;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import com.example.proyecto_examen_complexivo.modelo.Persona;
import com.example.proyecto_examen_complexivo.modelo.Rol;
import com.example.proyecto_examen_complexivo.modelo.Usuario;
import com.example.proyecto_examen_complexivo.service.Apis;
import com.example.proyecto_examen_complexivo.service.PersonaService;
import com.example.proyecto_examen_complexivo.service.UsuarioService;
import retrofit2.Call;
import retrofit2.Callback;
import static com.example.proyecto_examen_complexivo.Registro_Persona.p;


public class Registro_Usuario extends AppCompatActivity {
    private EditText usuario, contra, repetir;
    private Button btnregistra;
    PersonaService personaService;

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
                    Toast.makeText(Registro_Usuario.this, "Llene todos los campos", Toast.LENGTH_LONG).show();
                }
                if(contra.getText().length()<=6 ){
                    Toast.makeText(Registro_Usuario.this, "La contraseña 6 caracteres minimo", Toast.LENGTH_LONG).show();
                }else{
                    addPersona();
                }
            }
        });
    }
    public void addPersona() {

        personaService = Apis.getPesonaService();
        Call<Persona> call = personaService.createPerson(p);
        System.out.println("registrooooooooo "+Registro_Persona.p.getCedula());
        call.enqueue(new Callback<Persona>() {
            @Override
            public void onResponse(Call<Persona> call, retrofit2.Response<Persona> response) {

                if (response.isSuccessful()) {
                    System.out.println("personaaaaaaaaaaaaa"+response.body().getIdpersona());
                    Persona p = new Persona(response.body().getIdpersona());
                    Rol r= new Rol(1);
                    Usuario u=new Usuario(usuario.getText().toString(),contra.getText().toString(),p,r);
                    addUsuario(u);
                }
            }
            @Override
            public void onFailure(Call<Persona> call, Throwable t) {
                Toast.makeText(Registro_Usuario.this, "Error al agregar usuario", Toast.LENGTH_SHORT).show();
            }
        });

    }

    UsuarioService usuarioService;
    public void addUsuario(Usuario usuario) {

        usuarioService = Apis.getUsuarioService();
        Call<Usuario> call = usuarioService.addUsuario(usuario);
        call.enqueue(new Callback<Usuario>() {
            @Override
            public void onResponse(Call<Usuario> call, retrofit2.Response<Usuario> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(Registro_Usuario.this, "Usuario Agregada", Toast.LENGTH_LONG).show();
                    Intent home = new Intent(Registro_Usuario.this, Navegacion.class);
                    startActivity(home);
                    finish();
                }
            }

            @Override
            public void onFailure(Call<Usuario> call, Throwable t) {
                System.out.println(t.getMessage());
                System.out.println("Error");
            }

        });

    }


   /*


    public void getPersona(String cedula) {

        personaService = Apis.getPesonaService();
        Call<Persona> call = personaService.getPerson(cedula);
        call.enqueue(new Callback<Persona>() {
            @Override
            public void onResponse(Call<Persona> call, retrofit2.Response<Persona> response) {

                if (response.isSuccessful()) {
                    Persona p = new Persona(response.body().getIdpersona());
                    Rol r= new Rol(1);
                    Usuario u=new Usuario(usuario.getText().toString(),contra.getText().toString(),p,r);
                    addUsuario(u);
                }
            }
            @Override
            public void onFailure(Call<Persona> call, Throwable t) {
                Toast.makeText(Registro_Usuario.this, "Error al agregar usuario", Toast.LENGTH_SHORT).show();
            }
        });

    }*/
}