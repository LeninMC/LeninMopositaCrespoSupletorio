package com.example.leninmopositacresposupletorio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivityMCLB extends AppCompatActivity {
    private EditText txtcedula;
    private EditText txtcontraseña;
    private Button btnEntrar;
    private Button btnIrRegistrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtcedula = findViewById(R.id.edittext_usuario);
        txtcontraseña = findViewById(R.id.edittext_password);

        btnEntrar = findViewById(R.id.buttonEntrar);
        btnIrRegistrar = findViewById(R.id.buttonirRegistrar);
    }
    public void onClicIrRegistrar(View view){
        irRegistrar();
    }
    public void onClicEntrar(View view){
        entrar();
    }

    private void entrar() {
        UsuarioMCLB user = new UsuarioMCLB();
        UsuarioDalMCLB dal = new UsuarioDalMCLB(this);
        String cedula = txtcedula.getText().toString();
        String contraseña = txtcontraseña.getText().toString();
        user = dal.selectByCedula(cedula);
        if(!cedula.equals("") && !contraseña.equals("")){
            if(cedula.equals(user.getCedula()) && contraseña.equals(user.getContraseña())){
                Intent intent = new Intent(this,CrearMCLB.class);
                startActivity(intent);
            }else{
                Toast.makeText(this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this, "Campos obligatorios", Toast.LENGTH_SHORT).show();
        }

    }

    private void irRegistrar() {
        Intent intent = new Intent(this, MainActivityRegistrarMCLB.class);
        startActivity(intent);
    }
}