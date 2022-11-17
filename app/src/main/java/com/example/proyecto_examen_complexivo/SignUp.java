package com.example.proyecto_examen_complexivo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.proyecto_examen_complexivo.modelo.Persona;
import com.example.proyecto_examen_complexivo.service.Apis;
import com.example.proyecto_examen_complexivo.service.PersonaService;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.io.IOException;

public class SignUp extends AppCompatActivity {

    private EditText nombre, apellido, direccion, telefono, correo,cedula;
    private Button btnSiguiente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS, WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up1);

        nombre = findViewById(R.id.txt_nombre);
        apellido = findViewById(R.id.txt_apellido);
        direccion = findViewById(R.id.txt_direccion);
        telefono = findViewById(R.id.txt_telefono);
        correo = findViewById(R.id.txt_gmail);
        cedula = findViewById(R.id.txt_cedula);
        btnSiguiente = findViewById(R.id.btn_registrar);

        //ACCION DEL BOTON
        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nombre.getText().toString().isEmpty()||apellido.getText().toString().isEmpty()||direccion.getText().toString().isEmpty()
                ||telefono.getText().toString().isEmpty()||correo.getText().toString().isEmpty()||cedula.getText().toString().isEmpty()){
                    Toast.makeText(SignUp.this, "Llene todos los campos", Toast.LENGTH_SHORT).show();
                }else{
                    Persona p = new Persona();
                    p.setNombre(cedula.getText().toString());
                    p.setNombre(nombre.getText().toString());
                    p.setApellido(apellido.getText().toString());
                    p.setDireccion(direccion.getText().toString());
                    p.setCelular(telefono.getText().toString());
                    p.setCorreo(correo.getText().toString());
                    addPersona(p);
                    Intent home = new Intent(SignUp.this, SignUp2.class);
                    startActivity(home);
                    finish();
                }
            }
        });

    }

    PersonaService personaService;
    public void addPersona(Persona persona) {

        personaService = Apis.getPesonaService();
        Call<Persona> call = personaService.createPerson(persona);
        call.enqueue(new Callback<Persona>() {
            @Override
            public void onResponse(Call<Persona> call, retrofit2.Response<Persona> response) {

                if (response.isSuccessful()) {
                    Toast.makeText(SignUp.this, "Datos Guardados", Toast.LENGTH_LONG).show();
                }else{
                    try {
                        JSONObject jObjError = new JSONObject(response.errorBody().string());
                        System.out.println( jObjError.getString("message"));
                        System.out.println(jObjError.getJSONObject("message").getString("messageTemplate"));
                        Toast.makeText(SignUp.this, jObjError.getJSONObject("message").getString("message"), Toast.LENGTH_LONG).show();
                    } catch (JSONException e) {
                        System.out.println(e.getMessage());
                        Toast.makeText(SignUp.this, e.getMessage(), Toast.LENGTH_LONG).show();
                    } catch (IOException e) {

                    System.out.println(e.getMessage());
                        Toast.makeText(SignUp.this, e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<Persona> call, Throwable t) {
                Toast.makeText(SignUp.this, "Error al agregar usuario", Toast.LENGTH_SHORT).show();
            }
        });

    }
}