package com.example.leninmopositacresposupletorio;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class UsuarioHelperMCLB extends SQLiteOpenHelper {
    private String createTable_Clientes =  "CREATE TABLE Usuarios(codigo INTEGER PRIMARY KEY AUTOINCREMENT," +
            "Cedula TEXT, Password TEXT )";

    public UsuarioHelperMCLB(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
