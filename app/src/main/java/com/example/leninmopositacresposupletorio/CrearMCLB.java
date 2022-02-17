package com.example.leninmopositacresposupletorio;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;



import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CrearMCLB extends AppCompatActivity {

    private Spinner spinnerUsuarios;
    //private DatabaseReference databaseReference;
    //private DatabaseReference mDatabase;
    EditText tit;
    EditText multi;
    String nombre;
    String tipo;
    String id_tarea,tipo_tarea,titulo,descripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_mclb);

        spinnerUsuarios = findViewById(R.id.spinnerUsuarios);

        tit = findViewById(R.id.editText_Titulo);
        multi = findViewById(R.id.editTextDescripcion);


        tipo_tarea_aj();
        spinnerUsuarios.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Tipo_Tarea_MCLB categoria = (Tipo_Tarea_MCLB) adapterView.getItemAtPosition(i);
                tipo = categoria.getNombre().toString();
                //Toast.makeText(CrearTarea_AJ.this, categoria.getNombre().toString(), Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    @Override
    public  boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_creacion_mclb,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem menuItem) {
        int id = menuItem.getItemId();

        if (id == R.id.guardar){
            Toast.makeText(CrearMCLB.this, "Guardar", Toast.LENGTH_SHORT).show();

                Bundle bundle = getIntent().getExtras();
                nombre = bundle.getString("mail").toString();

                id_tarea = bundle.getString("mail").toString();
                tipo_tarea = tipo;
                titulo = tit.getText().toString();
                descripcion = multi.getText().toString();

                Tareas_MCLB tareas_aj = new Tareas_MCLB(id_tarea,tipo_tarea,titulo,descripcion);
                //databaseReference.child("Tareas").child((UUID.randomUUID().toString())).setValue(tareas_aj);





        }
        if (id == R.id.cancelar){
            Toast.makeText(CrearMCLB.this, "Opcion 1s", Toast.LENGTH_SHORT).show();
            finish();
        }
        if (id == R.id.cerrar_sesion){
            //FirebaseAuth.getInstance().signOut();
            startActivity(new Intent(CrearMCLB.this, MainActivityMCLB.class));

        }
            return super.onOptionsItemSelected(menuItem);
    }

    public void tipo_tarea_aj() {
        final List<Tipo_Tarea_MCLB> categorias = new ArrayList<>();
        //databaseReference.child("Tipo_Tarea").addListenerForSingleValueEvent(new ValueEventListener() {


    }

}