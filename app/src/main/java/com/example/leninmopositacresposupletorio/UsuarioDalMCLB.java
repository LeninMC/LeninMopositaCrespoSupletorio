package com.example.leninmopositacresposupletorio;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class UsuarioDalMCLB {
    private UsuarioHelperMCLB usuarioHelper;
    private SQLiteDatabase sql ;
    private Context context;

    public UsuarioDalMCLB(Context context) {
        this.context = context;
    }
    public void open(){
        usuarioHelper = new UsuarioHelperMCLB(context,"usuariosDB",null,1);
        sql = usuarioHelper.getWritableDatabase();
    }
    public long insert(UsuarioMCLB usuario){
        long count = 0;
        try {
            this.open();
            ContentValues values = new ContentValues();
            values.put("Cedula", usuario.getCedula());
            values.put("Nombre", usuario.getNombre());
            values.put("Apellido", usuario.getApellido());
            values.put("Contraseña", usuario.getContraseña());


            count = sql.insert("Usuarios",null,values);

        }catch (Exception e){
            throw e;
        }finally {
            sql.close();
        }
        return count;
    }
}
