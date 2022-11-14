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

import com.example.proyecto_examen_complexivo.adapter.CategoriaAdapter;
import com.example.proyecto_examen_complexivo.adapter.ServiciosAdapter;
import com.example.proyecto_examen_complexivo.adapter.SubcategoriaAdapter;
import com.example.proyecto_examen_complexivo.databinding.FragmentServiciosBinding;
import com.example.proyecto_examen_complexivo.modelo.Categoria;
import com.example.proyecto_examen_complexivo.modelo.Servicio;
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
 * Use the {@link ServiciosFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ServiciosFragment extends Fragment {



    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private FragmentServiciosBinding binding;

    private RecyclerView recyclerView, recyclerViewCate,recyclerViewSuc;
    //servicios
    private List<Servicio> servicioslist=new ArrayList<>();
    private ServiciosAdapter adapter;
    //categorias
    private List<Categoria> categoriaList=new ArrayList<>();
    private CategoriaAdapter adaptercategoria;
    //subcategorias
    private List<Subcategoria> subcategoriaList=new ArrayList<>();
    private SubcategoriaAdapter adaptersubcategoria;



    public ServiciosFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ServiciosFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ServiciosFragment newInstance(String param1, String param2) {
        ServiciosFragment fragment = new ServiciosFragment();
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
        binding=FragmentServiciosBinding.inflate(inflater, container,false);
        View root=binding.getRoot();

        //servicios
        adapter =new ServiciosAdapter(servicioslist,getContext());
        recyclerView= binding.recycleservicios;
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));
        recyclerView.setAdapter(adapter);
        retrofitIni();
        //categorias
        adaptercategoria=new CategoriaAdapter(categoriaList,getContext());
        recyclerViewCate=binding.recyclerViewCS;
        recyclerViewCate.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        recyclerViewCate.setAdapter(adaptercategoria);
        retrofitCa();
        //subcategorias
        adaptersubcategoria=new SubcategoriaAdapter(subcategoriaList,getContext());
        recyclerViewSuc=binding.recyclerViewSubCS;
        recyclerViewSuc.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        recyclerViewSuc.setAdapter(adaptersubcategoria);
        retrofitSu();

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }


    private void retrofitIni() {
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("http://prueba-env.eba-mvip6ksw.us-east-1.elasticbeanstalk.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Api apicliente=retrofit.create(Api.class);

        Call<List<Servicio>> res=apicliente.getServicio();
        res.enqueue(new Callback<List<Servicio>>() {
            @Override
            public void onResponse(Call<List<Servicio>> call, Response<List<Servicio>> response) {
                servicioslist.clear();
                servicioslist.addAll(response.body());
                adapter.notifyDataSetChanged();
                Toast.makeText(getContext(), "num "+servicioslist.size(), Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<List<Servicio>> call, Throwable t) {
             t.printStackTrace();
                Toast.makeText(getContext(), "ERROR", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void retrofitCa() {
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("http://prueba-env.eba-mvip6ksw.us-east-1.elasticbeanstalk.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Api apicliente=retrofit.create(Api.class);

        Call<List<Categoria>> res=apicliente.getCategoriaS();
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
    private void retrofitSu() {
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("http://prueba-env.eba-mvip6ksw.us-east-1.elasticbeanstalk.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Api apicliente=retrofit.create(Api.class);

        Call<List<Subcategoria>> res=apicliente.getSubcategoriaS();
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
}