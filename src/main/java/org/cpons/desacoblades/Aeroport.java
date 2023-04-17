package org.cpons.desacoblades;

import java.util.List;

public class Aeroport {
    private List<Avion> avions;

    public Aeroport(List<Avion> avions){
        this.avions = avions;
    }

    public void addAvion(Avion avion) {
        this.avions.add(avion);
    }

    public void assignarAvionaPasajero(Pasajero pasajero, String numVuelo) {
        for (Avion avion : this.avions) {
            if (avion.getNumVuelo().equals(numVuelo)) {
               if (!avion.addPasajero(pasajero)) System.out.println("Avión lleno");
                return;
            }
        }
        System.out.println("El vuelo " + numVuelo + " no está disponible");
    }

    public void assignarAvionaTripulante(Tripulante tripulante, String numVuelo) {
        for (Avion avion : this.avions) {
            if (avion.getNumVuelo().equals(numVuelo)) {
                avion.addTripulante(tripulante);
                return;
            }
        }
    }

    public double  despegar(org.cpons.acoblades.Aeroport.Avion avion, double kms){
        if (avion!=null) return avion.despegar(kms);
        return 0;
    }
    public double despegar(String vuelo, double kms) {
        Avion avion = getAvionByNumVuelo(vuelo);
        if (avion!=null) {
            return avion.despegar(kms);

        }
        System.out.println("El vuelo " + vuelo + "no está disponible");
        return 0d;
    }
    private Avion getAvionByNumVuelo(String vuelo) {
        for (Avion avion : avions) {
            if (avion.getNumVuelo().equals(vuelo)) return avion;
        }
        return null;
    }
}
