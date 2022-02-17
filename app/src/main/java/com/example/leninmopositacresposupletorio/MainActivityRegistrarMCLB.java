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
            Toast.makeText(this, "Campos obligatorios", Toast.LENGTH_SHORT).show();
        }
    }

    private Boolean validarCedula(String cedula){
        if (cedula.length() == 10) {
            //Obtenemos el digito de la region que sonlos dos primeros digitos
            String digito_region = cedula.substring(0, 2);
            ///TODO
            //Pregunto si la region existe ecuador se divide en 24 regiones
            if (Integer.parseInt(digito_region) >= 1 && Integer.parseInt(digito_region) <= 24) {

                // Extraigo el ultimo digito
                String ultimo_digito = cedula.substring(9, 10);

                //Agrupo todos los pares y los sumo
                int uno = Integer.parseInt(cedula.substring(1, 2));
                int dos = Integer.parseInt(cedula.substring(3, 4));
                int tres = Integer.parseInt(cedula.substring(5, 6));
                int cuatro = Integer.parseInt(cedula.substring(7, 8));

                //var cinco = cedula.substring(9, 10).toInt()
                int pares = uno + dos + tres + cuatro;
//                var pares = cedula.substring(1, 2).toInt() + cedula.substring(3, 4).toInt()
//                + cedula.substring(5, 6).toInt() + cedula.substring(7, 8).toInt()

                //Agrupo los impares, los multiplico por un factor de 2, si la resultante es > que 9 le restamos el 9 a la resultante
                String numero1 = cedula.substring(0, 1);
                numero1 = (Integer.parseInt(numero1) * 2).toString();
                if (Integer.parseInt(numero1) > 9) {
                    numero1= (Integer.parseInt(numero1) - 9).toString(); }

                var numero3 = cedula.substring(2, 3)
                numero3 = (Integer.parseInt(numero3) * 2).toString()
                if (numero3.toInt() > 9) {
                    numero3 = (Integer.parseInt(numero3) - 9).toString() }

                var numero5 = cedula.substring(4, 5)
                numero5 = (numero5.toInt() * 2).toString()
                if (numero5.toInt() > 9) {
                    numero5 = (numero5.toInt() - 9).toString() }

                var numero7 = cedula.substring(6, 7)
                numero7 = (numero7.toInt() * 2).toString()
                if (numero7.toInt() > 9) {
                    numero7 = (numero7.toInt() - 9).toString() }

                var numero9 = cedula.substring(8, 9)
                numero9 = (numero9.toInt() * 2).toString()
                if (numero9.toInt() > 9) {
                    numero9 = (numero9.toInt() - 9).toString() }

                var impares = numero1.toInt() + numero3.toInt() + numero5.toInt() + numero7.toInt() + numero9.toInt()

                //Suma total
                var suma_total = (pares + impares)

                //extraemos el primero digito
                var primer_digito_suma = (suma_total).toString().substring(0, 1)

                //Obtenemos la decena inmediata
                var decena = (primer_digito_suma.toInt() + 1) * 10

                //Obtenemos la resta de la decena inmediata - la suma_total esto nos da el digito validador
                var digito_validador = decena - suma_total

                //Si el digito validador es = a 10 toma el valor de 0
                if (digito_validador == 10) {
                    digito_validador = 0
                }


                //Validamos que el digito validador sea igual al de la cedula
                if (digito_validador == ultimo_digito.toInt()) {

                    Toast.makeText(this, "La Cedula es Correcta 👍🏻👍🏻", Toast.LENGTH_SHORT)
                            .show()
                    return true
                } else {

                    Toast.makeText(this, "La Cedula es InCorrecta ⚠️⚠️", Toast.LENGTH_SHORT).show()
                    return false
                }
            } else {
                Toast.makeText(this, "La cedula no pertenerce a ninguna region ⚠️", Toast.LENGTH_SHORT)
                        .show()
                return false
            }


            //TODO

        } else {
            Toast.makeText(this, "La cedula Tiene menos o mas de 10 Digitos ⚠️", Toast.LENGTH_SHORT)
                    .show()
            return false
        }
    }
}