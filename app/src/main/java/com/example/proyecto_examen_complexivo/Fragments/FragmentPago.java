package com.example.proyecto_examen_complexivo.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.example.proyecto_examen_complexivo.*;

public class FragmentPago extends Fragment {

    View view;
    EditText txt_numero_tarjeta;
    EditText txt_mes,txt_anio,txtCVV;
    Button btn_continuar, btn_cancelar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_datos_pago_ejemplo, container, false);
        txt_numero_tarjeta = view.findViewById(R.id.txtNumTarjeta);
        txt_mes = view.findViewById(R.id.txtMesVencimiento);
        txt_anio = view.findViewById(R.id.txtAnioVencimiento);
        txtCVV = view.findViewById(R.id.txtCVV);
        btn_continuar = view.findViewById(R.id.btn_continuar_pago);
        btn_cancelar=view.findViewById(R.id.btn_cancelar_pago);

        btn_continuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentFacturacion fr = new FragmentFacturacion();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.contentFrame, fr)
                        .addToBackStack(null)
                        .commit();
                ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Detalle de Factura");
            }
        });

        btn_cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        return view;
    }
}