package com.example.proyecto_examen_complexivo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.proyecto_examen_complexivo.Fragments.detalle_compras;
import com.example.proyecto_examen_complexivo.modelo.Carrito;
import com.squareup.picasso.Picasso;

public class EditarProductoDetalle extends AppCompatActivity {

    TextView txtNombre, txtPrecio, txtDescripcion;
    EditText txtCantidad;
    ImageView img;
    Button btnActualizar, btnEliminar;
    private Carrito producto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_producto_detalle);
        initViews();
        initValues();

        ActualizarDatos();
        EliminarDatoCarrito();
    }


    public void ActualizarDatos(){
        btnActualizar = findViewById(R.id.btnActualizarCarrito);
        btnActualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Carrito carritoActual = new Carrito();
                producto = (Carrito) getIntent().getExtras().getSerializable("productodetalle");
                Toast.makeText(EditarProductoDetalle.this, ""+producto.getId_producto(), Toast.LENGTH_SHORT).show();
                carritoActual.setCantidad(Integer.parseInt(txtCantidad.getText().toString()));

                carritoActual.ActualizarCarrito(EditarProductoDetalle.this, producto.getId_producto());
                finish();
            }
        });
    }

    public void EliminarDatoCarrito(){
        btnEliminar = findViewById(R.id.btnEliminarCarrito);
        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Carrito carritoActual = new Carrito();
                producto = (Carrito) getIntent().getExtras().getSerializable("productodetalle");
                Toast.makeText(EditarProductoDetalle.this, ""+producto.getId_producto(), Toast.LENGTH_SHORT).show();
                carritoActual.EliminarCarrito(EditarProductoDetalle.this, producto.getId_producto());
                finish();
            }
        });
    }

    private void initValues(){
        producto = (Carrito) getIntent().getExtras().getSerializable("productodetalle");
        txtNombre.setText(producto.getNombre_producto());
        txtPrecio.setText(String.valueOf(producto.getPrecio_producto()));
        txtDescripcion.setText(producto.getDescricpion_producto());
        txtCantidad.setText(String.valueOf(producto.getCantidad()));
        Picasso.get().load(producto.getImg()).resize(300,450).centerCrop()
                .into(img);
    }

    private void initViews(){
        txtNombre = findViewById(R.id.txtNombreEditarCarrito);
        txtPrecio = findViewById(R.id.txtPrecioEditarCarrito);
        txtDescripcion = findViewById(R.id.txtdescripcionEditarCarrito);
        txtCantidad = findViewById(R.id.editTextCantidadEditarCarrito);
        img = findViewById(R.id.imgeditarCarrito);
    }





}