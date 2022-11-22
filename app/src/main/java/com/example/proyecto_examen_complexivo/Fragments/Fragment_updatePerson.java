package com.example.proyecto_examen_complexivo.Fragments;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.proyecto_examen_complexivo.R;

public class Fragment_updatePerson extends Fragment {

    EditText txtCedula, txtNombre, txtApellido, txtDireccion, getTxtTelefono, txtEmail, txtUsuario, txtContraseña,txt_nueva_contra;
    Button btn_guardar, btn_cancelar, btn_editar;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup root= (ViewGroup) inflater.inflate(R.layout.fragment_update_person, container, false);
        txtCedula = root.findViewById(R.id.txt_cedula);
        txtCedula.setText("cedulaaaaaaaaaaaaaa");
        btn_guardar=root.findViewById(R.id.btn_guardar);
        return  root;

    }

}