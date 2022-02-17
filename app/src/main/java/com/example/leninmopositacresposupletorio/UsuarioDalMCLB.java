package com.example.leninmopositacresposupletorio;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class UsuarioDalMCLB {
    private UsuarioHelperMCLB usuarioHelper;
    private SQLiteDatabase sql ;
    private Context context;

    public ClienteDAL(Context context) {

        this.context = context;
    }
    public void open(){
        usuarioHelper = new UsuarioHelperMCLB(context,"usuarioDB",null,1);
        sql = usuarioHelper.getWritableDatabase();
    }
}
