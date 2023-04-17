package org.cpons.desacoblades;

import org.cpons.Utils;

import java.util.ArrayList;
import java.util.List;

import static org.cpons.Utils.*;

public class MainDesacoblades {
    private Aeroport aeroport;

    public void startMainDesacoblades(){
        aeroport = new Aeroport(generateAviones());
        addTripulantes();
        addPasajeros();
        despegar();
    }

    private List<Avion> generateAviones() {
        List<Avion> avions = new ArrayList<>();
        for (int i = 0; i < NUMS_VUELOS.length; i++) avions.add(new Avion(MODELOS_AVION[i], NUMS_VUELOS[i]));
        return avions;
    }
    private void despegar() {
        for (String vuelo : NUMS_VUELOS) {
            System.out.println();
            double kms = Utils.rnd.nextDouble(Utils.N_KMS);
            double consumo = aeroport.despegar(vuelo, kms);

            if (consumo>0) System.out.println("\nEl avión consumirá " + consumo
                    + " litros de combustible al recorrer " + kms + " km");
        }
    }


    private void addPasajeros(){
        final String defaultName = "Nom";
        final String defaultSurname = "apellido";
        for (int i = 0; i < NUMS_VUELOS.length; i++) {
            for (int j = 0; j < rnd.nextInt(NUMERO_PASAJEROS); j++) {
                aeroport.assignarAvionaPasajero(new Pasajero(defaultName+i+j, defaultSurname+i+j), NUMS_VUELOS[i]);
            }
        }
    }
    private void addTripulantes(){
        final String defaultName = "Nom";
        final String defaultSurname = "apellido";
        for (int i = 0; i < NUMS_VUELOS.length; i++) {
            for (int j = 0; j < NUMERO_TRIPULANTES; j++) {
                aeroport.assignarAvionaTripulante(new Tripulante(defaultName+i+j, defaultSurname+i+j,
                        CARGOS_TRIPULANTES[j]), NUMS_VUELOS[i]);
            }
        }
    }
}