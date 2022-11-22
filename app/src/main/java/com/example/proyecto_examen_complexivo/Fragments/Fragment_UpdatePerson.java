package com.example.proyecto_examen_complexivo.Fragments;

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
import com.example.proyecto_examen_complexivo.datos_sqlite.CargarUsuario;
import com.example.proyecto_examen_complexivo.modelo.Usuario;

import java.util.ArrayList;


public class Fragment_UpdatePerson extends Fragment {


    EditText txtCedula, txtNombre, txtApellido, txtDireccion, getTxtTelefono, txtEmail, txtUsuario, txtContrasenia, txt_nueva_contra;
    Button btn_guardar, btn_cancelar, btn_editar;
    View view;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        CargarUsuario usu = new CargarUsuario(getContext());

        view = inflater.inflate(R.layout.fragment_update_person, container, false);
        txtCedula = (EditText) view.findViewById(R.id.txt_cedula_update);
        txtNombre = (EditText) view.findViewById(R.id.txt_nombre_update);
        txtApellido = view.findViewById(R.id.txt_apellido_update);
        txtDireccion = view.findViewById(R.id.txtDireccionUpdate);
        getTxtTelefono = view.findViewById(R.id.txt_telefono_update);
        txtEmail = view.findViewById(R.id.txt_email);
        txtUsuario = view.findViewById(R.id.txt_usuario_update);
        txtContrasenia = view.findViewById(R.id.txt_clave_nueva);
        txt_nueva_contra = view.findViewById(R.id.txt_repetir_clave);

        //CARGAR DATOS USUARIO
        txtCedula.setText(usu.listarUsuarioP().get(0).getIdpersona().getCedula());
        txtNombre.setText(usu.listarUsuarioP().get(0).getIdpersona().getNombre());
        txtApellido.setText(usu.listarUsuarioP().get(0).getIdpersona().getApellido());
        txtDireccion.setText(usu.listarUsuarioP().get(0).getIdpersona().getDireccion());
        getTxtTelefono.setText(usu.listarUsuarioP().get(0).getIdpersona().getCelular());
        txtEmail.setText(usu.listarUsuarioP().get(0).getIdpersona().getCorreo());
        txtUsuario.setText(usu.listarUsuarioP().get(0).getUsuusuario());

        btn_guardar = (Button) view.findViewById(R.id.btn_guardar);
        btn_guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Presioan", Toast.LENGTH_LONG).show();
            }
        });
        return view;

    }
}