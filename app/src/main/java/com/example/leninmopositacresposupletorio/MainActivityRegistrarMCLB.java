package com.example.leninmopositacresposupletorio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivityRegistrarMCLB extends AppCompatActivity {
    private EditText txtcedula;
    private EditText txtnombre;
    private EditText txtapellido;
    private EditText txtcontraseña;
    private Button btnRegistrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_registrar_mclb);

        txtcedula = findViewById(R.id.edittext_Cedula);
        txtnombre = findViewById(R.id.edittext_Nombre);
        txtapellido = findViewById(R.id.edittext_Apellido);
        txtcontraseña = findViewById(R.id.edittext_Contraseña);

        btnRegistrar = findViewById(R.id.buttonRegistrar);
    }
    public void onClicRegistrar(View view){
        registrar();
    }

    private void registrar() {
        UsuarioDalMCLB dal = new UsuarioDalMCLB(this);
        // dal.open();

        String nombre = txtnombre.getText().toString();
        String apellido = edNombre.getText().toString();
        String correo = edNombre.getText().toString();

        Cliente cliente = new Cliente();
        cliente.setNombre(nombre);
        cliente.setApellido(apellido);
        cliente.setCorreo(correo);
        if(!nombre.equals("") && !apellido.equals("") && !apellido.equals("")) {
            long cant = dal.insert(cliente);
            //limpiar controles
            edNombre.setText("");
            edApellido.setText("");
            edCorreo.setText("");
            if(cant > 0){
                Toast.makeText(this, "Se inserto un cliente", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this, "No se inserto ningun campo", Toast.LENGTH_SHORT).show();
            }

        }else{
            Toast.makeText(this, "Campos obligatorios", Toast.LENGTH_SHORT).show();
        }
    }
}