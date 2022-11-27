package com.example.proyecto_examen_complexivo;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.proyecto_examen_complexivo.modelo.Carrito;
import com.example.proyecto_examen_complexivo.modelo.Producto;
import com.squareup.picasso.Picasso;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Random;

public class ProductoServicioDetalle extends AppCompatActivity {

    private ImageView imgDetail;
    private TextView txtNombre;
    private TextView txtDescripcion, txtPrecio, txtCantidad;
    private Producto productoDetalle;
    private Button btnGuardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_producto_servicio_detalle);
        setTitle(getClass().getSimpleName());
        initViews();
        initValues();
        GuardarCarrito();
    }


    public void GuardarCarrito(){
        productoDetalle = (Producto) getIntent().getExtras().getSerializable("itemDetail");
        btnGuardar = findViewById(R.id.btnGuardarCarrito);
        txtNombre = findViewById(R.id.txtNombre_Producto3);
        txtDescripcion = findViewById(R.id.txtDescripcionProducto3);
        txtPrecio = findViewById(R.id.txtPrecio_Producto3);
        txtCantidad = findViewById(R.id.editTextCantidadCarrito);
        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Carrito carritoActual = new Carrito();
                carritoActual.setId_producto(CodigoArchivo());
                carritoActual.setIdproducto(productoDetalle.getId());
                carritoActual.setNombre_producto(productoDetalle.getNombre());
                carritoActual.setPrecio_producto(productoDetalle.getPrecio());
                carritoActual.setDescricpion_producto(productoDetalle.getDescripcion());
                carritoActual.setCantidad(Integer.parseInt(txtCantidad.getText().toString()));
                carritoActual.setImg(productoDetalle.getFoto());
                carritoActual.setTipo("producto");
                carritoActual.Guardar(ProductoServicioDetalle.this);
                finish();
            }
        });

    }

    private void initViews(){
        imgDetail = findViewById(R.id.imgfotoproductocompra3);
        txtNombre = findViewById(R.id.txtNombre_Producto3);
        txtDescripcion = findViewById(R.id.txtDescripcionProducto3);
        txtPrecio = findViewById(R.id.txtPrecio_Producto3);
    }

    private void initValues(){

        productoDetalle = (Producto) getIntent().getExtras().getSerializable("itemDetail");
        Picasso.get().load(productoDetalle.getFoto()).resize(300,450).centerCrop().into(imgDetail);
        txtNombre.setText(productoDetalle.getNombre());
        txtPrecio.setText(String.valueOf(productoDetalle.getPrecio()));
        txtDescripcion.setText(productoDetalle.getDescripcion());
    }


    public String CodigoArchivo() {
       // txtCodigoArchivo = findViewById(R.id.txtCodigoArchivoPdf);
        String serial = "";
        Random random = new Random();
        String abecedario = "ABCDEFGHIJKMOPRSTUVWXYZ";
        String cadena = "";
        int m = 0, pos = 0, num;
        while (m < 1) {
            pos = (int) (random.nextDouble() * abecedario.length() - 1 + 0);
            num = (int) (random.nextDouble() * 9999 + 1000);
            cadena = cadena + abecedario.charAt(pos) + num;
            pos = (int) (random.nextDouble() * abecedario.length() - 1 + 0);
            cadena = cadena + abecedario.charAt(pos);
            serial = "ARCHIVO-" + cadena;
            m++;
        }
        return serial;
    }

}