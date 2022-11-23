package com.example.proyecto_examen_complexivo.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.proyecto_examen_complexivo.Navegacion;
import com.example.proyecto_examen_complexivo.R;
import com.example.proyecto_examen_complexivo.Registro_Persona;
import com.example.proyecto_examen_complexivo.Registro_Usuario;
import com.example.proyecto_examen_complexivo.base_temp.DbHelper;
import com.example.proyecto_examen_complexivo.datos_sqlite.CargarUsuario;
import com.example.proyecto_examen_complexivo.modelo.Persona;
import com.example.proyecto_examen_complexivo.modelo.Usuario;
import com.example.proyecto_examen_complexivo.service.Apis;
import com.example.proyecto_examen_complexivo.service.PersonaService;
import com.example.proyecto_examen_complexivo.service.UsuarioService;
import retrofit2.Call;
import retrofit2.Callback;

import java.util.ArrayList;

import static com.example.proyecto_examen_complexivo.Registro_Persona.p;


public class Fragment_UpdatePerson extends Fragment {


    EditText txtCedula, txtNombre, txtApellido, txtDireccion, txtTelefono, txtEmail, txtUsuario, txtContrasenia, txt_nueva_contra;
    Button btn_guardar, btn_cancelar, btn_editar;
    View view;
    boolean validar = false;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        CargarUsuario usu = new CargarUsuario(getContext());

        view = inflater.inflate(R.layout.fragment_update_person, container, false);
        txtCedula = (EditText) view.findViewById(R.id.txt_cedula_update);
        txtNombre = (EditText) view.findViewById(R.id.txt_nombre_update);
        txtApellido = view.findViewById(R.id.txt_apellido_update);
        txtDireccion = view.findViewById(R.id.txtDireccionUpdate);
        txtTelefono = view.findViewById(R.id.txt_telefono_update);
        txtEmail = view.findViewById(R.id.txt_email);
        txtUsuario = view.findViewById(R.id.txt_usuario_update);
        txtContrasenia = view.findViewById(R.id.txt_clave_nueva);
        txt_nueva_contra = view.findViewById(R.id.txt_repetir_clave);

        //CARGAR DATOS USUARIO
        txtCedula.setText(usu.listarUsuarioP().get(0).getIdpersona().getCedula());
        txtNombre.setText(usu.listarUsuarioP().get(0).getIdpersona().getNombre());
        txtApellido.setText(usu.listarUsuarioP().get(0).getIdpersona().getApellido());
        txtDireccion.setText(usu.listarUsuarioP().get(0).getIdpersona().getDireccion());
        txtTelefono.setText(usu.listarUsuarioP().get(0).getIdpersona().getCelular());
        txtEmail.setText(usu.listarUsuarioP().get(0).getIdpersona().getCorreo());
        txtUsuario.setText(usu.listarUsuarioP().get(0).getUsuusuario());


        btn_guardar = (Button) view.findViewById(R.id.btn_guardar);
        btn_guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (txtNombre.getText().toString().isEmpty() || txtApellido.getText().toString().isEmpty() || txtDireccion.getText().toString().isEmpty() || txtTelefono.getText().toString().isEmpty() || txtEmail.getText().toString().isEmpty() || txtCedula.getText().toString().isEmpty()) {
                    Toast.makeText(getContext(), "Llene todos los campos", Toast.LENGTH_SHORT).show();
                } else {
                    if (txtCedula.getText().length() < 10) {
                        Toast.makeText(getContext(), "Cedula incorrecta", Toast.LENGTH_SHORT).show();
                        validar = true;
                    }
                    if (txtTelefono.getText().length() < 10) {
                        Toast.makeText(getContext(), "Telefono incorrecto", Toast.LENGTH_SHORT).show();
                        validar = true;
                    }
                }

                //CARGAR DATOS OBJETO PERSONA
                Persona p = new Persona();
                p.setCedula(txtCedula.getText().toString());
                p.setNombre(txtNombre.getText().toString());
                p.setApellido(txtApellido.getText().toString());
                p.setDireccion(txtDireccion.getText().toString());
                p.setCelular(txtTelefono.getText().toString());
                p.setCorreo(txtEmail.getText().toString());
                getPersona(txtCedula.getText().toString());
                Toast.makeText(getContext(), "Gurdar", Toast.LENGTH_LONG).show();
            }
        });


        btn_cancelar = (Button) view.findViewById(R.id.btn_cancelar);
        btn_cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Cancelar", Toast.LENGTH_LONG).show();
            }
        });
        return view;

    }

    public void getPersona(String cedula) {

        PersonaService personaService;
        personaService = Apis.getPesonaService();
        Call<Persona> call = personaService.getPerson(cedula);
        call.enqueue(new Callback<Persona>() {
            @Override
            public void onResponse(Call<Persona> call, retrofit2.Response<Persona> response) {

                if (response.isSuccessful()) {
                    Toast.makeText(getContext(), "Cedula ya registrada", Toast.LENGTH_SHORT).show();
                    validar = true;
                } else if (response.body() == null) {
                    Toast.makeText(getContext(), "Datos Correctos", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<Persona> call, Throwable t) {
                Toast.makeText(getContext(), "Error datos no validos" + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }


    UsuarioService usuarioService;

    public void updateUsuario(Usuario usuario) {

        usuarioService = Apis.getUsuarioService();
        Call<Usuario> call = usuarioService.updateUsuario(usuario);
        call.enqueue(new Callback<Usuario>() {
            @Override
            public void onResponse(Call<Usuario> call, retrofit2.Response<Usuario> response) {
                if (response.isSuccessful()) {
                    Usuario usuario1;
                    usuario1 = response.body();
                    //Agregar Usuario Base sqlite
                    DbHelper bd = new DbHelper(getContext(), "basetemp", null, 2);
                    bd.agregarUsuario(usuario1.getUsu_id(), usuario1.getUsuusuario(), usuario1.getUsu_contrasena(), txtCedula.getText().toString(), txtNombre.getText().toString(), txtApellido.getText().toString(), txtDireccion.getText().toString(), txtTelefono.getText().toString(), txtEmail.getText().toString(), usuario1.getRol_id().getIdrol(), usuario1.getIdpersona().getIdpersona());

                    Toast.makeText(getContext(), "Usuario Actualizado", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getContext(), response.message(), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Usuario> call, Throwable t) {
                Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }

        });

    }
}