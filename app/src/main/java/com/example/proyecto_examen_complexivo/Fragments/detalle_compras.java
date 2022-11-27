package com.example.proyecto_examen_complexivo.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.proyecto_examen_complexivo.EditarProductoDetalle;
import com.example.proyecto_examen_complexivo.R;
import com.example.proyecto_examen_complexivo.adapter.detallecomprasAdapter;
import com.example.proyecto_examen_complexivo.databinding.FragmentDetalleComprasBinding;
import com.example.proyecto_examen_complexivo.facturacion;
import com.example.proyecto_examen_complexivo.modelo.Carrito;
import com.example.proyecto_examen_complexivo.modelo.Producto;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link detalle_compras#newInstance} factory method to
 * create an instance of this fragment.
 */
public class detalle_compras extends Fragment implements detallecomprasAdapter.RecyclerItemClick {


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private FragmentDetalleComprasBinding binding;


    //carrito
    private ArrayList<Carrito> listCarrito = new ArrayList<>();
    private detallecomprasAdapter adapter;
    private TextView txtTotalCompras;
    private Button btnComprar;
    //recyclerview
    private RecyclerView recyclerView;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public detalle_compras() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static detalle_compras newInstance(String param1, String param2) {
        detalle_compras fragment = new detalle_compras();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        consultarComprasCarrito();

    }


    public void consultarComprasCarrito(){
        Carrito carrito = new Carrito();
        listCarrito = carrito.getcomprados(detalle_compras.this.getContext());
      //  listCarrito.clear();
//        adapter.notifyDataSetChanged();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentDetalleComprasBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        //carrito
        adapter = new detallecomprasAdapter(listCarrito, getContext(), this);
        recyclerView= binding.recyclecompras;
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(adapter);
        consultarComprasCarrito();
        txtTotalCompras = binding.txtTotalComprasCarrito;
        Carrito carrito = new Carrito();
        listCarrito = carrito.getcomprados(detalle_compras.this.getContext());
        double resultado = 0;
        double suma=0;
        for (Carrito car: listCarrito){
            if(car.getCantidad()>1){
                suma=car.getCantidad()*car.getPrecio_producto();
                resultado+=suma;
            }else{
                resultado += car.getPrecio_producto();
            }

        }
        txtTotalCompras.setText("$ "+resultado);
        btnComprar = binding.btnComprar;
        btnComprar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirFragmnet();
               // Intent intent = new Intent(detalle_compras.this.getContext(), facturacion.class);
              //  startActivity(intent);
            }
        });

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    public void abrirFragmnet (){
        FragmentPago fr = new FragmentPago();
        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.contentFrame, fr)
                .addToBackStack(null)
                .commit();
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Datos Pago");

    }

    @Override
    public void itemCLick(Carrito producto) {
        Intent intent = new Intent(detalle_compras.this.getContext(), EditarProductoDetalle.class);
        intent.putExtra("productodetalle", producto);
        startActivity(intent);
    }
}