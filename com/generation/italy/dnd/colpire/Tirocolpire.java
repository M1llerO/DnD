package com.generation.italy.dnd.colpire;
 
import com.generation.italy.dnd.simdado.Dado;
import com.generation.italy.dnd.abilita.Tiroabilita;
import com.generation.library.*;
 
// TIRO COLPIRE - gestisce il tiro per colpire, CA e dadi danno
public class Tirocolpire {
 
    public static void esegui(int modificatore) {
 
        System.out.println("--- Tiro per colpire ---");
 
        // LANCIO D20 - riutilizzo il metodo di Tiroabilita
        int tiroBase = Tiroabilita.lanciaD20();
 
        if (tiroBase == 1) {
            // FUMBLE - mancato automatico, modificatore non applicato
            System.out.println("*** FUMBLE! Hai mancato! ***");
            int effetto = Dado.tira(3);
            if (effetto == 1) System.out.println("Hai colpito te stesso!");
            if (effetto == 2) System.out.println("Hai perso l'arma!");
            if (effetto == 3) System.out.println("Sei caduto a terra!");
        } else {
            if (tiroBase == 20) {
                // CRITICO - colpisce sempre indipendentemente dalla CA
                System.out.println("*** CRITICO! ***");
            }
 
            // APPLICO IL MODIFICATORE
            int tiroFinale = tiroBase + modificatore;
            System.out.println("Tiro finale: " + tiroBase + " + mod(" + modificatore + ") = " + tiroFinale);
 
            // CONFRONTO CON LA CLASSE ARMATURA
            System.out.print("Classe Armatura del nemico? ");
            int ca = Console.readInt();
 
            if (tiroFinale < ca && tiroBase != 20) {
                System.out.println("Hai mancato! CA nemica: " + ca);
            } else {
 
                // COLPO ANDATO A SEGNO
                System.out.println("Hai colpito! Tiro il danno...");
                int totale = 0;
                String riepilogo = "";
 
                // CICLO DADI DANNO
                boolean AltroDado = true;
                while (AltroDado) {
 
                    // DADO.CHIEDIGFACCE() gestisce input e validazione
                    int facce = Dado.chiedigFacce();
 
                    System.out.print("Quanti dadi lanci? ");
                    int q = Console.readInt();
 
                    // FOR - chiama Dado.tira() per ogni dado
                    for (int i = 0; i < q; i++) {
                        int risultato = Dado.tira(facce);
                        totale += risultato;
                        riepilogo += "D" + facce + ": " + risultato + "  ";
                    }
 
                    System.out.print("Hai altri dadi? (s/n): ");
                    String risposta = Console.readString();
                    AltroDado = risposta.equals("s");
                }
 
                // SE CRITICO - il danno viene raddoppiato
                if (tiroBase == 20) {
                    totale = totale * 2;
                    System.out.println("*** Danno raddoppiato: " + totale + " ***");
                }
 
                // RIEPILOGO FINALE
                System.out.println("--- Riepilogo dadi ---");
                System.out.println(riepilogo);
                System.out.println("Totale danno: " + totale);
            }
        }
    }
}
