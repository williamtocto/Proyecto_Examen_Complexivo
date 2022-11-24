package com.example.proyecto_examen_complexivo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import com.example.proyecto_examen_complexivo.Fragments.detalle_compras;
import com.example.proyecto_examen_complexivo.adapter.FacturacionAdapter;
import com.example.proyecto_examen_complexivo.modelo.Carrito;

import java.util.ArrayList;

public class facturacion extends AppCompatActivity {

    ArrayList<Carrito> listCarrito;
    RecyclerView recyclerView1;
    TextView txtTotalPagar;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facturacion);
        listCarrito = new ArrayList<>();
        recyclerView1 = (RecyclerView) findViewById(R.id.recyclerViewFactura);
        recyclerView1.setLayoutManager(new LinearLayoutManager(facturacion.this));
        consultarComprasCarrito();
        FacturacionAdapter adapter = new FacturacionAdapter(listCarrito, facturacion.this);
        recyclerView1.setAdapter(adapter);
        txtTotalPagar = findViewById(R.id.txtTotalPagar);

    }

    public void consultarComprasCarrito(){
        Carrito carrito = new Carrito();
        listCarrito = carrito.getcomprados(facturacion.this);

    }
}