package org.cpons.acoblades;

import org.cpons.Utils;

import java.util.ArrayList;
import java.util.List;

public class Aeroport {
    private List<Avion> avions = generarAviones();


    public void addAvion(Avion avion) {
        this.avions.add(avion);
    }

    private List<Avion> generarAviones() {
        List<Avion> avionList = new ArrayList<>();
        for (int i = 0; i < Utils.NUMS_VUELOS.length; i++) avionList.add(new Avion(Utils.MODELOS_AVION[i], Utils.NUMS_VUELOS[i]));
        return avionList;
    }
    public double  despegar(Avion avion, double kms){
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
            this.pasajeros = generarPasajeros();
            this.tripulantes = generarTripulantes();
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
        private List<Pasajero> generarPasajeros() {
            final int numPasajeros = Utils.rnd.nextInt(Utils.NUMERO_PASAJEROS);
            final String defaultName = "Pasajero";
            final String defaultSurname = "apellido";
            List<Pasajero> pasajeros1 = new ArrayList<>(numPasajeros);
            for (int j = 0; j < numPasajeros; j++) {
                pasajeros1.add(new Pasajero(defaultName + j, defaultSurname + j));
                if (pasajeros1.size()==numAsientos) return pasajeros1;
            }
            return pasajeros1;
        }

        private List<Tripulante> generarTripulantes() {
            final int numPasajeros = Utils.NUMERO_TRIPULANTES;
            final String defaultName = "Tripulante";
            final String defaultSurname = "apellido";
            List<Tripulante> tripulantes1 = new ArrayList<>(numPasajeros);
            for (int j = 0; j < numPasajeros; j++) {
                tripulantes1.add(new Tripulante(defaultName + j, defaultSurname + j, Utils.CARGOS_TRIPULANTES[j]));
            }
            return tripulantes1;
        }

    public String getNumVuelo() {
            return this.numVuelo;
        }

        public boolean addPasajero(Pasajero pasajero) {
            if (pasajeros.size()==numAsientos) {
                this.pasajeros.add(pasajero);
                return true;
            }
            return false;
        }

        public List<Pasajero> getPasajeros() {
            return this.pasajeros;
        }

        public void addTripulante(Tripulante tripulante) {
            tripulantes.add(tripulante);
        }

        public Tripulante getTripulante(String fullName, String cargo) {
            for (Tripulante t : tripulantes) {
                if (fullName.equalsIgnoreCase(t.getNombre()+t.getApellido()) && t.getCargo().equalsIgnoreCase(cargo)) return t;
            }
            return null;
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

    public class Pasajero {
        private String nombre;
        private String apellido;

        public Pasajero(String nombre, String apellido) {
            this.nombre = nombre;
            this.apellido = apellido;
        }

        public String getNombre() {
            return this.nombre;
        }

        public String getApellido() {
            return this.apellido;
        }

        @Override
        public String toString() {
            return  "{ nombre='" + nombre + '\'' +
                    ", apellido='" + apellido + '\'' + '}';
        }
    }

    public class Tripulante {
        private String nombre;
        private String apellido;
        private String cargo;

        public Tripulante(String nombre, String apellido, String cargo) {
            this.nombre = nombre;
            this.apellido = apellido;
            this.cargo = cargo;
        }

        public String getNombre() {
            return this.nombre;
        }

        public String getApellido() {
            return this.apellido;
        }

        public String getCargo() {
            return this.cargo;
        }

        @Override
        public String toString() {
            return  "{ nombre='" + nombre + '\'' +
                    ", apellido='" + apellido + '\'' +
                    ", cargo='" + cargo + '\'' + '}';
        }
    }
}