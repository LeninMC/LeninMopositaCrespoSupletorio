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
        String cedula = txtcedula.getText().toString();
        String nombre = txtnombre.getText().toString();
        String apellido = txtapellido.getText().toString();
        String contraseña = txtcontraseña.getText().toString();

        UsuarioMCLB usuario = new UsuarioMCLB();
        usuario.setCedula(cedula);
        usuario.setNombre(nombre);
        usuario.setApellido(apellido);
        usuario.setContraseña(contraseña);
        if(!nombre.equals("") && !apellido.equals("") && !apellido.equals("")) {
          if(esCedula(cedula)){
              long cant = dal.insert(usuario);
              //limpiar controles
              txtcedula.setText("");
              txtnombre.setText("");
              txtapellido.setText("");
              txtcontraseña.setText("");
              if(cant > 0){
                  Toast.makeText(this, "Se inserto un usuario", Toast.LENGTH_SHORT).show();
              }else{
                  Toast.makeText(this, "No se inserto ningun campo", Toast.LENGTH_SHORT).show();
              }
          }else{
              Toast.makeText(this, "La Cedula es incorrecta", Toast.LENGTH_SHORT).show();
          }

        }else{
            Toast.makeText(this, "Campos obligatorios", Toast.LENGTH_SHORT).show();
        }
    }


    public boolean esCedula(String cedula) {
        boolean cedulaCorrecta;
        try {
            if (cedula.length() == 10) {
                // Coeficientes de validación cédula
                // El decimo digito se lo considera dígito verificador
                int[] coefValCedula = {2, 1, 2, 1, 2, 1, 2, 1, 2};
                int verificador = Integer.parseInt(cedula.substring(9, 10));
                int suma = 0;
                int digito;
                for (int i = 0; i < (cedula.length() - 1); i++) {
                    digito = Integer.parseInt(cedula.substring(i, i + 1)) * coefValCedula[i];
                    suma += ((digito % 10) + (digito / 10));
                }
                cedulaCorrecta = ((suma % 10 == 0 && verificador == 0) || (10 - suma % 10 == verificador));
            } else {
                cedulaCorrecta = false;
            }
        } catch (Exception e) {
            cedulaCorrecta = false;
        }
        return cedulaCorrecta;
    }
    public boolean validar_Password(String password){
        int continuos = 0;
        int numero = 0;
        int especial = 0;
        int fin = 0xFF.toChar();
        int minuscula = 0;
        int mayuscula = 0;
        boolean es_validar = true;
        if (password.length() < 6 || password.length() > 10) return false
        for (i in 0; password.length) {
            val c = password[i]
            if (c <= ' ' || c > '~') {
                es_validar = false
                break
            }
            if (c > ' ' && c < '0' || c >= ':' && c < 'A' || c >= '[' && c < 'a' || c >= '{' && c.toInt() < 127) {
                especial++
            }
            if (c >= '0' && c < ':') numero++
            if (c >= 'A' && c < '[') mayuscula++
            if (c >= 'a' && c < '{') minuscula++
            continuos = if (c == fin) continuos + 1 else 0
            if (continuos >= 7) {
                es_validar = false
                break
            }
            fin = c
        }
        es_validar = es_validar && especial > 0 && numero > 0 && minuscula > 0 && mayuscula > 0
        return es_validar
    }

}