package com.example.leninmopositacresposupletorio;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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
        tipo_tarea_MCLB();
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem menuItem) {
        int id = menuItem.getItemId();

        if (id == R.id.guardar){
            Toast.makeText(MainActivityCrearListaMCLB.this, "Guardar", Toast.LENGTH_SHORT).show();

            Bundle bundle = getIntent().getExtras();
            nombre = bundle.getString("mail").toString();

            id_tarea = bundle.getString("mail").toString();
            tipo_tarea = tipo;
            titulo = tit.getText().toString();
            descripcion = multi.getText().toString();

            Tareas_MCLB tareas_aj = new Tareas_MCLB(id_tarea,tipo_tarea,titulo,descripcion);
           // databaseReference.child("Tareas").child((UUID.randomUUID().toString())).setValue(tareas_aj);





        }
        if (id == R.id.cancelar){
            Toast.makeText(MainActivityCrearListaMCLB.this, "Opcion 1s", Toast.LENGTH_SHORT).show();
            finish();
        }
        if (id == R.id.cerrar_sesion){
           // FirebaseAuth.getInstance().signOut();
            startActivity(new Intent(MainActivityCrearListaMCLB.this, MainActivityMCLB.class));

        }
        return super.onOptionsItemSelected(menuItem);
    }
    public void tipo_tarea_MCLB() {
        final List<Tipo_Tarea_MCLB> categorias = new ArrayList<>();
        //databaseReference.child("Tipo_Tarea").addListenerForSingleValueEvent(new ValueEventListener() {

            //int  descripcion =Integer.parseInt(ds.child("Descrip").getValue().toString());
            //String nombre = ds.child("Nombre").getValue().toString();
            categorias.add(new Tipo_Tarea_MCLB(descripcion, nombre));

                    ArrayAdapter<Tipo_Tarea_MCLB> arrayAdapter =
                            new ArrayAdapter<>(MainActivityCrearListaMCLB.this,
                                    android.R.layout.simple_dropdown_item_1line, categorias);



            }



    }
}