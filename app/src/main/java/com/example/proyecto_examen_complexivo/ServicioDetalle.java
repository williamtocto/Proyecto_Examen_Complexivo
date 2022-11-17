package com.example.proyecto_examen_complexivo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.proyecto_examen_complexivo.modelo.Servicio;
import com.squareup.picasso.Picasso;

public class ServicioDetalle extends AppCompatActivity {
    private ImageView imgDetail;
    private TextView txtNombre, txtPrecio, txtDescripcion;
    private Servicio detalleServicio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servicio_detalle);
        setTitle(getClass().getSimpleName());

        initViews();
        initValues();
    }

    private void initViews(){
        imgDetail = findViewById(R.id.imgFotoServicio);
        txtNombre = findViewById(R.id.txtNombre_Servicio);
        txtDescripcion = findViewById(R.id.txtDescripcionServicio3);
        txtPrecio = findViewById(R.id.txtPrecio_Servicio3);
    }

    private void initValues(){
        detalleServicio = (Servicio) getIntent().getExtras().getSerializable("itemDetail");
        Picasso.get().load(detalleServicio.getFoto()).resize(300,450).centerCrop()
                .into(imgDetail);
        txtNombre.setText(detalleServicio.getNombre());
        txtDescripcion.setText(detalleServicio.getDescripcion());
        txtPrecio.setText(String.valueOf(detalleServicio.getPrecio()));
    }
}