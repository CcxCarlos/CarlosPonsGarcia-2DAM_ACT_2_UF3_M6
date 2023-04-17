package org.cpons.desacobladesWithInterficies;

public class Tripulante implements Persona {
    private String nombre;
    private String apellido;
    private String cargo;
    public Tripulante(String nombre, String apellido, String cargo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cargo = cargo;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public String getApellido() {
        return apellido;
    }

    @Override
    public String toString() {
        return "Tripulante{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", cargo='" + cargo + '\'' +
                '}';
    }
}
