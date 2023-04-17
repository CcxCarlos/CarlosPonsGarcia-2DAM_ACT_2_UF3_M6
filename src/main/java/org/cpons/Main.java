package org.cpons;

import org.cpons.acoblades.MainAcoblades;
import org.cpons.desacoblades.MainDesacoblades;
import org.cpons.desacobladesWithInterficies.MainDesacobladesWithInterface;

public class Main {
    public static void main(String[] args) {
        System.out.println("\nMain acoblades:");
        new MainAcoblades().startMainAcoblades();

        System.out.println("\nMain desacoblades:");
        new MainDesacoblades().startMainDesacoblades();

        System.out.println("\nMain desacoblades amb interfície:");
        new MainDesacobladesWithInterface().startMainDesacoblades();
    }
}