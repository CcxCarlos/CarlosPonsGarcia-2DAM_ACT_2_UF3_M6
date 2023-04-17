package org.cpons.desacoblades;

public class Tripulante {
    String nombre;
    String apellido;
    private String cargo;
    public Tripulante(String nombre, String apellido, String cargo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cargo = cargo;
    }


    @Override
    public String toString() {
        return  "{ nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", cargo='" + cargo + '\'' + '}';
    }
}
