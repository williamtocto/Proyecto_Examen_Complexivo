package com.example.proyecto_examen_complexivo.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.proyecto_examen_complexivo.R;
import com.example.proyecto_examen_complexivo.adapter.CategoriaAdapter;
import com.example.proyecto_examen_complexivo.adapter.ProductoAdapter;
import com.example.proyecto_examen_complexivo.adapter.SubcategoriaAdapter;
import com.example.proyecto_examen_complexivo.databinding.ActivityMainBinding;
import com.example.proyecto_examen_complexivo.databinding.FragmentProductosBinding;
import com.example.proyecto_examen_complexivo.modelo.Categoria;
import com.example.proyecto_examen_complexivo.modelo.Producto;
import com.example.proyecto_examen_complexivo.modelo.Subcategoria;
import com.example.proyecto_examen_complexivo.network.Api;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProductosFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProductosFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private FragmentProductosBinding binding;
    //productos
    private List<Producto> listproducto =new ArrayList<>();
    private ProductoAdapter adapter;
    //recicleviews
    private RecyclerView recyclerView,recyclersubcategoria, recyclerViewcategoria;
    //subcategoria
    private List<Subcategoria> subcategoriaList =new ArrayList<>();
    private SubcategoriaAdapter adaptersubcategoria;

    //categoria
    private List<Categoria> categoriaList=new ArrayList<>();
    private CategoriaAdapter adaptercategoria;

    public ProductosFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProductosFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProductosFragment newInstance(String param1, String param2) {
        ProductosFragment fragment = new ProductosFragment();
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
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding=FragmentProductosBinding.inflate(inflater, container,false);
        View root=binding.getRoot();
        //producto
        adapter=new ProductoAdapter(listproducto,getContext());
        recyclerView=binding.recycleproductos;
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));
        recyclerView.setAdapter(adapter);
        retrofitIni();

        //subcategoria
        adaptersubcategoria=new SubcategoriaAdapter(subcategoriaList,getContext());
        recyclersubcategoria=binding.recyclersubcategoria;
        recyclersubcategoria.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL,false));
        recyclersubcategoria.setAdapter(adaptersubcategoria);
        retrofitSubCa();

        //categoria
        adaptercategoria=new CategoriaAdapter(categoriaList,getContext());
        recyclerViewcategoria=binding.recyclercategoria;
        recyclerViewcategoria.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        recyclerViewcategoria.setAdapter(adaptercategoria);
        retrofitCategoria();


        // Inflate the layout for this fragment
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    private void retrofitIni(){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("http://prueba-env.eba-mvip6ksw.us-east-1.elasticbeanstalk.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Api apicliente=retrofit.create(Api.class);

        Call<List<Producto>> res=apicliente.getProducto();
        res.enqueue(new Callback<List<Producto>>() {
            @Override
            public void onResponse(Call<List<Producto>> call, Response<List<Producto>> response) {
                listproducto.clear();
                listproducto.addAll(response.body());
                adapter.notifyDataSetChanged();
                Toast.makeText(getContext(), "productos "+listproducto.size(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<List<Producto>> call, Throwable t) {
                t.printStackTrace();
                Toast.makeText(getContext(), "ERROR", Toast.LENGTH_SHORT).show();

            }
        });
    }
    private void retrofitSubCa(){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("http://prueba-env.eba-mvip6ksw.us-east-1.elasticbeanstalk.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Api apicliente=retrofit.create(Api.class);

        Call<List<Subcategoria>> res=apicliente.getSubcategoria();
        res.enqueue(new Callback<List<Subcategoria>>() {
            @Override
            public void onResponse(Call<List<Subcategoria>> call, Response<List<Subcategoria>> response) {
                subcategoriaList.clear();
                subcategoriaList.addAll(response.body());
                adaptersubcategoria.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<List<Subcategoria>> call, Throwable t) {
                t.printStackTrace();
                Toast.makeText(getContext(), "ERROR", Toast.LENGTH_SHORT).show();

            }
        });
    }
    private void retrofitCategoria(){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("http://prueba-env.eba-mvip6ksw.us-east-1.elasticbeanstalk.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Api apicliente=retrofit.create(Api.class);

        Call<List<Categoria>> res=apicliente.getCegoria();
        res.enqueue(new Callback<List<Categoria>>() {
            @Override
            public void onResponse(Call<List<Categoria>> call, Response<List<Categoria>> response) {
                categoriaList.clear();
                categoriaList.addAll(response.body());
                adaptercategoria.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<Categoria>> call, Throwable t) {
                t.printStackTrace();
                Toast.makeText(getContext(), "ERROR", Toast.LENGTH_SHORT).show();

            }
        });
    }
}