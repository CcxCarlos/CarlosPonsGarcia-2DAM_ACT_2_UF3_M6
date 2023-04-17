package org.cpons.desacobladesWithInterficies;

import java.util.ArrayList;
import java.util.List;

public class Jet implements Avion{
    private final int DEFAULT_N_ASIENTOS = 6;
    private final double CONSUMO_X_100KM = 81;
    private final String modelo;
    private String numVuelo;
    private List<Pasajero> pasajeros;
    private List<Tripulante> tripulantes;
    private int numAsientos;


    public Jet(String modelo, String numVuelo) {
        this.modelo = modelo;
        this.numVuelo = numVuelo;
        this.numAsientos = DEFAULT_N_ASIENTOS;
        this.pasajeros = new ArrayList<>();
        this.tripulantes = new ArrayList<>();
    }

    public Jet(String modelo, String numVuelo, int numAsientos) {
        this.modelo = modelo;
        this.numVuelo = numVuelo;
        this.numAsientos = numAsientos;
        this.pasajeros = new ArrayList<>();
        this.tripulantes = new ArrayList<>();
    }

    @Override
    public void addPersona(Persona persona){
        if (persona instanceof Tripulante) tripulantes.add((Tripulante) persona);
        else {
            if (pasajeros.size()<numAsientos) pasajeros.add((Pasajero) persona);

        }
    }

    @Override
    public double despegar(double kms) {
        if (pasajeros.isEmpty()) {
            System.out.println("El vuelo " + numVuelo + " no despega, " + "esperando pasajeros...");
            return 0d;
        }
        else {
            System.out.println("El vuelo " + this.numVuelo + " despega: ");
            System.out.println(this);
            return (kms/100) * CONSUMO_X_100KM;
        }
    }

    public String getNumVuelo() {
        return this.numVuelo;
    }

    public List<Pasajero> getPasajeros() {
        return this.pasajeros;
    }

    @Override
    public String toString() {
        return  getClass().getSimpleName() + ' ' + modelo +" {" +
                "\n Tripulantes: " +
                "\n    ->" + tripulantes +
                "\n Pasajeros: " +
                "\n    ->" + pasajeros + '}';
    }
}