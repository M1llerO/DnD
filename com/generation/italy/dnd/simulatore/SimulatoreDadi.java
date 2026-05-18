package com.generation.italy.dnd.simulatore;

import com.generation.italy.dnd.personaggio.Personaggio;
import com.generation.italy.dnd.caratteristiche.CaratteristichePersonaggio;
import com.generation.italy.dnd.abilita.Tiroabilita;
import com.generation.italy.dnd.colpire.Tirocolpire;
import com.generation.italy.dnd.informazione.Informazionedadi;
import com.generation.library.*;

// SIMULATORE DADI - coordinatore, richiama le altre classi
public class SimulatoreDadi {

    public static void avvia(Personaggio pg) {

        System.out.println("=== Simulatore dadi D&D ===");

        // RICHIAMO INFORMAZIONE DADI
        Informazionedadi.mostra();

        // CICLO PRINCIPALE
        boolean rilancia = true;
        while (rilancia == true) {

            // SCELTA TIPO DI TIRO
            System.out.println("Che tipo di tiro vuoi fare?");
            System.out.println("1. Tiro per colpire");
            System.out.println("2. Tiro di abilita'");
            int tipoTiro = Console.readInt();

            // SCELTA CARATTERISTICA E CALCOLO MODIFICATORE
            int modificatore = CaratteristichePersonaggio.scegliModificatore(pg);

            // CHIAMO LA CLASSE GIUSTA IN BASE AL TIPO DI TIRO
            if (tipoTiro == 2) {
                Tiroabilita.esegui(modificatore);
            } else {
                Tirocolpire.esegui(modificatore);
            }

            // CHIEDO SE VUOLE RILANCIARE
            System.out.print("Vuoi lanciare ancora? (s/n): ");
            String risposta = Console.readString();
            rilancia = risposta.equals("s");
        }
    }
}