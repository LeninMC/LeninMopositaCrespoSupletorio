package com.example.leninmopositacresposupletorio;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

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
            values.put("Password", usuario.getContraseña());


            count = sql.insert("Usuarios",null,values);

        }catch (Exception e){
            throw e;
        }finally {
            sql.close();
        }
        return count;
    }
    public UsuarioMCLB selectByCedula (String cedula){

        try {
            this.open();
            String select = "SELECT Cedula,Nombre,Apellido,Password " +
                    "FROM Usuarios " +
                    "WHERE Cedula=" + cedula;

            Cursor cursor = sql.rawQuery(select,null);
            if(cursor.moveToFirst()){
                UsuarioMCLB usuario = new UsuarioMCLB();
                usuario.setCedula(cursor.getString(0));
                usuario.setNombre(cursor.getString(1));
                usuario.setApellido(cursor.getString(2));
                usuario.setContraseña(cursor.getString(3));
                return usuario;
            }

        }catch (Exception e){
            throw e;


        }finally {
            sql.close();
        }
        return null;
    }
}
