package com.example.proyecto_examen_complexivo;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.proyecto_examen_complexivo.modelo.Producto;
import com.squareup.picasso.Picasso;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ProductoServicioDetalle extends AppCompatActivity {

    private ImageView imgDetail;
    private TextView txtNombre;
    private TextView txtDescripcion, txtPrecio;
    private Producto productoDetalle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_producto_servicio_detalle);
        setTitle(getClass().getSimpleName());

        initViews();
        initValues();
    }

    private void initViews(){
        imgDetail = findViewById(R.id.imgfotoproductocompra3);
        txtNombre = findViewById(R.id.txtNombre_Producto3);
        txtDescripcion = findViewById(R.id.txtDescripcionProducto3);
        txtPrecio = findViewById(R.id.txtPrecio_Producto3);
    }

        private void initValues(){

            productoDetalle = (Producto) getIntent().getExtras().getSerializable("itemDetail");
            Picasso.get().load(productoDetalle.getFoto()).resize(300,450).centerCrop()
                    .into(imgDetail);
            txtNombre.setText(productoDetalle.getNombre());
            txtPrecio.setText(String.valueOf(productoDetalle.getPrecio()));
            txtDescripcion.setText(productoDetalle.getDescripcion());

    }


}