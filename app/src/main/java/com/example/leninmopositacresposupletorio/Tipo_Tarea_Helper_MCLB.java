package com.example.leninmopositacresposupletorio;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Tipo_Tarea_Helper_MCLB extends SQLiteOpenHelper {
    private String createTable_Tareas = "CREATE TABLE Tareas(codigo INTEGER PRIMARY KEY AUTOINCREMENT," +
            " TEXT,Nombre TEXT ,Apellido TEXT , Password TEXT  )";

    public UsuarioHelperMCLB(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
}
