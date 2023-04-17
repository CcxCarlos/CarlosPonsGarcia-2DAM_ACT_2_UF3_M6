package org.cpons.desacoblades;

public class Pasajero  {
    String nombre;
    String apellido;
    public Pasajero(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    @Override
    public String toString() {
        return  "{ nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' + '}';
    }
}
