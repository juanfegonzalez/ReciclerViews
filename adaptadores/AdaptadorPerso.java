package com.example.juanfe.reciclerviews.adaptadores;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.juanfe.reciclerviews.R;
import com.example.juanfe.reciclerviews.utils.Persona;

import java.util.List;

public class AdaptadorPerso extends RecyclerView.Adapter<AdaptadorPerso.miHolder> {
    private List list;
    private Context context;
     //interfaz de callback
    private OnPersonaRecyclerListener onPersonaRecyclerListener;



    public AdaptadorPerso(List list, Context context) {
        this.list = list;
        this.context = context;
         //interfaz de callback
        onPersonaRecyclerListener = (OnPersonaRecyclerListener) context;
    }

    @NonNull
    @Override
    public miHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item,viewGroup,false);
        miHolder holder;
        holder = new miHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull miHolder miHolder, int i) {
        final Persona p = (Persona)list.get(i);
        
        miHolder.getImagen().setImageResource(p.getImagen());
        miHolder.getNombre().setText(p.getNombre());
        miHolder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    onPersonaRecyclerListener.OnPersonaRecylcerSelected(p);
                }


            }
        });

    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    class miHolder extends RecyclerView.ViewHolder{
        ImageView imagen;
        TextView nombre;
        CheckBox checkBox;

        private miHolder(@NonNull View itemView) {
            super(itemView);

            imagen = itemView.findViewById(R.id.imagenRecycler);
            nombre = itemView.findViewById(R.id.textoRecycler);
            checkBox = itemView.findViewById(R.id.checkboxRecycler);
        }

        private ImageView getImagen() {
            return imagen;
        }

        private TextView getNombre() {
            return nombre;
        }



    }
    //interfaz de callback
    public interface OnPersonaRecyclerListener{
        void OnPersonaRecylcerSelected(Persona p);

    }
}
