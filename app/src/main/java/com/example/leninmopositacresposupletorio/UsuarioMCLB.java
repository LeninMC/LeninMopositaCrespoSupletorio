package com.example.leninmopositacresposupletorio;

public class UsuarioMCLB {
    private String Cedula;
    private String Nombre;
    private String Apellido;
    private String contraseña;

    public UsuarioMCLB(String cedula, String nombre, String apellido, String contraseña) {
        Cedula = cedula;
        Nombre = nombre;
        Apellido = apellido;
        this.contraseña = contraseña;
    }

    public UsuarioMCLB(){

    }

    public String getCedula() {
        return Cedula;
    }

    public void setCedula(String cedula) {
        Cedula = cedula;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
}
