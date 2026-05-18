package com.generation.italy.dnd.abilita;

import com.generation.italy.dnd.simdado.Dado;
import com.generation.library.*;

// TIRO ABILITA' - gestisce il tiro di abilita' con vantaggio/svantaggio
public class Tiroabilita {

    public static void esegui(int modificatore) {

        System.out.println("--- Tiro di abilita' ---");

        // VANTAGGIO/SVANTAGGIO
        int tiroBase = lanciaD20();

        if (tiroBase == 1) {
            // FUMBLE - fallimento automatico, modificatore non applicato
            System.out.println("*** FUMBLE! ***");
            int effetto = Dado.tira(3);
            if (effetto == 1) System.out.println("Hai colpito te stesso!");
            if (effetto == 2) System.out.println("Hai perso l'arma!");
            if (effetto == 3) System.out.println("Sei caduto a terra!");
        } else if (tiroBase == 20) {
            // CRITICO - successo automatico
            System.out.println("*** CRITICO! ***");
            int tiroFinale = tiroBase + modificatore;
            System.out.println("Tiro finale: " + tiroBase + " + mod(" + modificatore + ") = " + tiroFinale);
        } else {
            // TIRO NORMALE - applico il modificatore
            int tiroFinale = tiroBase + modificatore;
            System.out.println("Tiro finale: " + tiroBase + " + mod(" + modificatore + ") = " + tiroFinale);
        }
    }

    // LANCIA D20 - gestisce vantaggio/svantaggio e restituisce il tiroBase
    public static int lanciaD20() {
        System.out.print("Hai vantaggio, svantaggio, o nessuno dei due? (v/s/no): ");
        String vs = Console.readString();

        int tiroBase;
        if (vs.equals("v")) {
            // VANTAGGIO - lancia due D20 e tiene il piu' alto
            int dado1 = Dado.tira(20);
            int dado2 = Dado.tira(20);
            System.out.println("Dadi: " + dado1 + " e " + dado2);
            tiroBase = dado1 > dado2 ? dado1 : dado2;
            System.out.println("Tieni il piu' alto: " + tiroBase);
        } else if (vs.equals("s")) {
            // SVANTAGGIO - lancia due D20 e tiene il piu' basso
            int dado1 = Dado.tira(20);
            int dado2 = Dado.tira(20);
            System.out.println("Dadi: " + dado1 + " e " + dado2);
            tiroBase = dado1 < dado2 ? dado1 : dado2;
            System.out.println("Tieni il piu' basso: " + tiroBase);
        } else {
            // NESSUNO - lancio normale
            tiroBase = Dado.tira(20);
            System.out.println("D20: " + tiroBase);
        }
        return tiroBase;
    }
}
