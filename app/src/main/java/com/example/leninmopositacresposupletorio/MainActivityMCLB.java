package com.example.leninmopositacresposupletorio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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
        txtcedula = findViewById(R.id.edittext_password);

        btnEntrar = findViewById(R.id.buttonEntrar);
        btnIrRegistrar = findViewById(R.id.buttonirRegistrar);
    }
    public void onClicIrRegistrar(View view){
        irRegistrar();
    }

    private void irRegistrar() {
        Intent intent = new Intent(this, MainActivityRegistrarMCLB.class);
        startActivity(intent);
    }
}