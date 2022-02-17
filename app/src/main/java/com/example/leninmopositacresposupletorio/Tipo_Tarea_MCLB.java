package com.example.leninmopositacresposupletorio;

public class Tipo_Tarea_MCLB {
    int descripcion;
    String nombre;

    public Tipo_Tarea_MCLB(int descripcion, String nombre) {
        this.descripcion = descripcion;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(int descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
