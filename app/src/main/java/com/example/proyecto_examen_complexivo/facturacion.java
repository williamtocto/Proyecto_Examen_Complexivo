package com.example.proyecto_examen_complexivo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.proyecto_examen_complexivo.Fragments.detalle_compras;
import com.example.proyecto_examen_complexivo.adapter.FacturacionAdapter;
import com.example.proyecto_examen_complexivo.base_temp.DbHelper;
import com.example.proyecto_examen_complexivo.modelo.Carrito;
import com.example.proyecto_examen_complexivo.modelo.Persona;
import com.example.proyecto_examen_complexivo.modelo.Usuario;
import com.example.proyecto_examen_complexivo.network.Constantes;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class facturacion extends AppCompatActivity {

    ArrayList<Carrito> listCarrito;
    RecyclerView recyclerView1;
    TextView txtTotalPagar, txtUsuarioFacturacion, txtCedulaFacturacion, txtDireccionFacturacion,txtCorreoFacturacion, txtTelefonoFacturacion, txtFechaFacturacion;

    private Persona persona=new Persona();
    private Usuario usuario=new Usuario();


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
        txtUsuarioFacturacion= findViewById(R.id.txtUsuarioFacturacion);
        txtCedulaFacturacion= findViewById(R.id.txtCedulaFacturacion);
        txtDireccionFacturacion =findViewById(R.id.txtDireccionFacturacion);
        txtCorreoFacturacion =findViewById(R.id.txtCorreoFacturacion);
        txtTelefonoFacturacion =findViewById(R.id.txtTelefonoFacturacion);
        txtFechaFacturacion = findViewById(R.id.txtFechaFacturacion);


        double resultado = 0;
        for (Carrito car: listCarrito){
            double suma=0;
            if(car.getCantidad()>1){
                suma=car.getPrecio_producto()*car.getCantidad();
                resultado+=suma;
            }else{
                resultado += car.getPrecio_producto();
            }

        }
        consultausuario();
        txtTotalPagar.setText(resultado+"");
        String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        txtFechaFacturacion.setText(date);

    }

    public void consultausuario(){
        DbHelper dbHelper = new DbHelper(facturacion.this, "basetemp", null, 2);
        String sql = "SELECT cedula, nombre, apellido, direccion, telefono, correo FROM usuario where ud_id = '0' ";
        Cursor cursor = dbHelper.query(sql);
        while (cursor.moveToNext()){

            persona.setCedula(cursor.getString(0));
            txtCedulaFacturacion.setText(persona.getCedula());
            persona.setNombre(cursor.getString(1));
            persona.setApellido(cursor.getString(2));
            txtUsuarioFacturacion.setText(persona.getNombre()+" "+persona.getApellido());
            persona.setDireccion(cursor.getString(3));
            txtDireccionFacturacion.setText(persona.getDireccion());
            persona.setCelular(cursor.getString(4));
            txtTelefonoFacturacion.setText(persona.getCelular());
            persona.setCorreo(cursor.getString(5));
            txtCorreoFacturacion.setText(persona.getCorreo());
            dbHelper.close();
        }
        Toast.makeText(this, ""+persona.getNombre(), Toast.LENGTH_SHORT).show();


    }

    public void consultarComprasCarrito(){
        Carrito carrito = new Carrito();
        listCarrito = carrito.getcomprados(facturacion.this);

    }
}