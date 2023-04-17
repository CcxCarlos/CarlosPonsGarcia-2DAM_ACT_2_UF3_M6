package org.cpons.desacobladesWithInterficies;


import org.cpons.Utils;

import java.util.ArrayList;
import java.util.List;

import static org.cpons.Utils.*;

public class MainDesacobladesWithInterface {
    private Aeroport aeroport;

    public void startMainDesacoblades(){
        aeroport = new Aeroport(generateAviones());
        addPersoas();
        despegar();
    }

    private List<Avion> generateAviones() {
        List<Avion> avions = new ArrayList<>();
        for (int i = 0; i < NUMS_VUELOS.length; i++){
            Avion avion;
            if (i==2) avion = new Jet(MODELOS_AVION[i], NUMS_VUELOS[i]);
            else avion = new AvionComercial(MODELOS_AVION[i], NUMS_VUELOS[i]);
            avions.add(avion);
        }
        return avions;
    }
    private void addPersoas() {
        Persona persona;
        final String defaultName = "nom";
        final String defaultSurname = "apellido";
        for (int i = 0; i < NUMS_VUELOS.length; i++) {
            for (int j = 0; j < rnd.nextInt(NUMERO_PASAJEROS); j++) {
                persona = new Pasajero(defaultName+i+j, defaultSurname+i+j);
                aeroport.assignarAvionaPersona(persona, NUMS_VUELOS[i]);
            }
            for (int j = 0; j < NUMERO_TRIPULANTES; j++) {
                persona = new Tripulante(defaultName+i+j, defaultSurname+i+j, CARGOS_TRIPULANTES[j]);
                aeroport.assignarAvionaPersona(persona, NUMS_VUELOS[i]);
            }
        }
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
}