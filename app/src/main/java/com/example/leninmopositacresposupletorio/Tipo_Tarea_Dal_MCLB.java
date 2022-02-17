package com.example.leninmopositacresposupletorio;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class Tipo_Tarea_Dal_MCLB {
    private Tipo_Tarea_Helper_MCLB tareaHelper;
    private SQLiteDatabase sql ;
    private Context context;

    public Tipo_Tarea_Dal_MCLB(Context context) {
        this.context = context;
    }
    public void open(){
        tareaHelper = new Tipo_Tarea_Helper_MCLB(context,"tareasDB",null,1);
        sql = tareaHelper.getWritableDatabase();
    }

    public long insert(Tipo_Tarea_MCLB tarea){
        long count = 0;
        try {
            this.open();
            ContentValues values = new ContentValues();
            values.put("Descripcion", tarea.getDescripcion());
            values.put("Nombre", tarea.getNombre());


            count = sql.insert("Tareas",null,values);

        }catch (Exception e){
            throw e;
        }finally {
            sql.close();
        }
        return count;
    }
}
