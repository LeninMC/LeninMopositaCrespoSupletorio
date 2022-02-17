package com.example.leninmopositacresposupletorio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class MainActivityCrearListaMCLB extends AppCompatActivity {
    EditText tit;
    EditText multi;
    String nombre;
    String tipo;
    String id_tarea,tipo_tarea,titulo,descripcion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_crear_lista_mclb);

        tit = findViewById(R.id.editText_Titulo);
        multi = findViewById(R.id.editTextDescripcion);

    }
}