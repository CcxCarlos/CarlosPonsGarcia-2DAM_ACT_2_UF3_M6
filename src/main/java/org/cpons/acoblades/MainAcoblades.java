package org.cpons.acoblades;

import org.cpons.Utils;

public class MainAcoblades {

    public void startMainAcoblades(){
        Aeroport aeroport = new Aeroport();
        for (String s : Utils.NUMS_VUELOS) {
            System.out.println();
            double kms = Utils.rnd.nextDouble(Utils.N_KMS);
            double consumo = aeroport.despegar(s, kms);

            if (consumo>0) System.out.println("\nEl avión consumirá " + consumo
                    + " litros de combustible al recorrer " + kms + " km");
        }
    }
}