package org.cpons.desacoblades;

import java.util.ArrayList;
import java.util.List;

public class Avion {
    private final int DEFAULT_N_ASIENTOS = 189;
    private final double CONSUMO_X_100KM = 235;
    private final String modelo;
    private String numVuelo;
    private List<Pasajero> pasajeros;
    private List<Tripulante> tripulantes;
    private int numAsientos;


    public Avion(String modelo, String numVuelo) {
        this.modelo = modelo;
        this.numVuelo = numVuelo;
        this.numAsientos = DEFAULT_N_ASIENTOS;
        this.pasajeros = new ArrayList<>();
        this.tripulantes = new ArrayList<>();
    }

    public Avion(String modelo, String numVuelo, int numAsientos) {
        this.modelo = modelo;
        this.numVuelo = numVuelo;
        this.numAsientos = numAsientos;
        this.pasajeros = new ArrayList<>();
        this.tripulantes = new ArrayList<>();
    }

    public boolean addPasajero(Pasajero pasajero) {
        if (pasajeros.size()<numAsientos) {
            this.pasajeros.add(pasajero);
            return true;
        }
        return false;
    }

    public void addTripulante(Tripulante tripulante){
        tripulantes.add(tripulante);
    }
    public String getNumVuelo() {
        return this.numVuelo;
    }

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

    @Override
    public String toString() {
        return  "Avion" + ' ' + modelo + " {" +
                "\n Tripulantes: " +
                "\n    ->" + tripulantes +
                "\n Pasajeros: " +
                "\n    ->" + pasajeros + '}';
    }
}