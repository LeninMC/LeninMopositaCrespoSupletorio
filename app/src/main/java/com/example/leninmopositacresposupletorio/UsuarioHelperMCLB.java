package com.example.leninmopositacresposupletorio;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class UsuarioHelperMCLB extends SQLiteOpenHelper {
    private String createTable_Usuarios = "CREATE TABLE Usuarios(codigo INTEGER PRIMARY KEY AUTOINCREMENT," +
            "Cedula TEXT,Nombre TEXT ,Apellido TEXT , Password TEXT  )";

    public UsuarioHelperMCLB(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        // ejecutar el sql para crear la estructura de las tablas
        db.execSQL(createTable_Usuarios);
        // sql: segunda tabla
        // vistas ,triggers ,etc
        // db.execSQL("INSERT INTO ......");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //sql borar las tablas
        db.execSQL("DROP TABLE IF EXISTS Usuarios");
        //sql para crear tabla o tablas con la nueva estructura
        db.execSQL(createTable_Usuarios);
    }
}
