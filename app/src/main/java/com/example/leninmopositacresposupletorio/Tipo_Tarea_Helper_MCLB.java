package com.example.leninmopositacresposupletorio;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Tipo_Tarea_Helper_MCLB extends SQLiteOpenHelper {
    private String createTable_Tareas = "CREATE TABLE Tareas(codigo INTEGER PRIMARY KEY AUTOINCREMENT," +
            " TEXT,Descripcion Integer ,Nombre TEXT )";

    public Tipo_Tarea_Helper_MCLB(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // ejecutar el sql para crear la estructura de las tablas
        db.execSQL(createTable_Tareas);
        // sql: segunda tabla
        // vistas ,triggers ,etc
        // db.execSQL("INSERT INTO ......");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //sql borar las tablas
        db.execSQL("DROP TABLE IF EXISTS Tareas");
        //sql para crear tabla o tablas con la nueva estructura
        db.execSQL(createTable_Tareas);
    }
}
