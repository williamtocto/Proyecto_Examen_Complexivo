package com.example.proyecto_examen_complexivo.adapter;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyecto_examen_complexivo.R;
import com.example.proyecto_examen_complexivo.modelo.Carrito;
import com.squareup.picasso.Picasso;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class detallecomprasAdapter extends RecyclerView.Adapter<detallecomprasAdapter.ViewHolder>{

    private ArrayList<Carrito> ListaCarrito;

    private Context context;

    public detallecomprasAdapter(ArrayList<Carrito> listaCarrito, Context context) {
        ListaCarrito = listaCarrito;
        this.context = context;
    }

    @NonNull
    @Override
    public detallecomprasAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_detalle_compras, null, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull detallecomprasAdapter.ViewHolder holder, int position) {

        holder.id_Producto.setText(ListaCarrito.get(position).getId_producto());
        holder.Nombre_Producto.setText(ListaCarrito.get(position).getNombre_producto());
        holder.Descripcion_Producto.setText(ListaCarrito.get(position).getDescricpion_producto());
        holder.Precio_Producto.setText(String.valueOf(ListaCarrito.get(position).getPrecio_producto()));
        holder.Cantidad_Producto.setText(String.valueOf(ListaCarrito.get(position).getCantidad()));
        Picasso.get().load(ListaCarrito.get(position).getImg()).resize(300,450).centerCrop()
                .into(holder.img);
    }

    @Override
    public int getItemCount() {
        return ListaCarrito.size();
    }



    public class ViewHolder  extends RecyclerView.ViewHolder{

        TextView Nombre_Producto, Descripcion_Producto, Cantidad_Producto, Precio_Producto, id_Producto;
        ImageView img;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            id_Producto = itemView.findViewById(R.id.txtId_Producto);
            Nombre_Producto = itemView.findViewById(R.id.txtNombreProductoDetalleCompras);
            Cantidad_Producto = itemView.findViewById(R.id.txtCantidadProductaDeta);
            Precio_Producto = itemView.findViewById(R.id.txtPrecioProductoDetalleCompras);
            Descripcion_Producto = itemView.findViewById(R.id.txtDescripcionDetalleCompras);
            img = itemView.findViewById(R.id.imgFotoDetalleCompras);

        }
    }
}
