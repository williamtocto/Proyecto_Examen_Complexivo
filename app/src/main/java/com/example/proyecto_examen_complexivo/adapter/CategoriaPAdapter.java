package com.example.proyecto_examen_complexivo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyecto_examen_complexivo.R;
import com.example.proyecto_examen_complexivo.modelo.CategoriaP;

import java.util.List;

public class CategoriaPAdapter extends RecyclerView.Adapter<CategoriaPAdapter.ViewHolder> {
    private List<CategoriaP> categoriaList;
    private Context context;



    public CategoriaPAdapter(List<CategoriaP> categoriaList, Context context) {
        this.categoriaList = categoriaList;
        this.context = context;
    }

    @NonNull
    @Override
    public CategoriaPAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(context).inflate(R.layout.item_categoria,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoriaPAdapter.ViewHolder holder, int position) {
        CategoriaP ca=categoriaList.get(position);
        holder.nombrecategoria.setText(ca.getNombre());
    }

    @Override
    public int getItemCount() {
        return categoriaList.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView nombrecategoria;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nombrecategoria=itemView.findViewById(R.id.categorias);
        }

    }
}
