package com.example.juanfe.reciclerviews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.juanfe.reciclerviews.adaptadores.AdaptadorPerso;
import com.example.juanfe.reciclerviews.utils.Persona;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdaptadorPerso.OnPersonaRecyclerListener {
    RecyclerView recyclerView;
    Button boton;
    TextView textView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
        construirRecycler();
        acciones();

    }

    private void acciones() {
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        recyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    private void construirRecycler() {
        ArrayList<Persona> personas= new ArrayList<>();
        personas.add(new Persona("nombre 1",R.drawable.juego_01));
        personas.add(new Persona("nombre 2",R.drawable.juego_02));
        personas.add(new Persona("nombre 3",R.drawable.juego_06));
        personas.add(new Persona("nombre 4",R.drawable.juego_09));
        AdaptadorPerso adaptadorPerso = new AdaptadorPerso(personas,this);
        recyclerView.setAdapter(adaptadorPerso);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,true));
    }

    private void instancias() {
        recyclerView = findViewById(R.id.recyclerNombre);
        boton = findViewById(R.id.boton);
        textView = findViewById(R.id.textoNombre);

    }

    @Override
    public void OnPersonaRecylcerSelected(Persona p) {
        //arraylist para añadir y quitar nombres
        textView.append(p.getNombre()+"\n");
    }
}
