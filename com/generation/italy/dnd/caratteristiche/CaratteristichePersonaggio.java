package com.generation.italy.dnd.caratteristiche;

import com.generation.italy.dnd.personaggio.Personaggio;
import com.generation.library.*;

// CARATTERISTICHE PERSONAGGIO - inserimento FOR, DES, COS, INT, SAG, CAR
// + riepilogo scheda + scelta modificatore durante il gioco
public class CaratteristichePersonaggio {

    // INSERIMENTO STATISTICHE E RIEPILOGO SCHEDA
    public static void assegna(Personaggio pg) {

        int PuntiTotali = 27;

        System.out.println("Hai tutte le caratteristiche ad 8, e 27 punti disponibili.");
        System.out.println("Incrementa le tue caratteristiche fino ad un massimo di 15.");
        System.out.println();

        // FORZA
        do {
            System.out.print("Forza (8-15, punti rimasti: " + PuntiTotali + "): ");
            pg.forza = Console.readInt();
            if (pg.forza < 8 || pg.forza > 15) System.out.println("Valore non valido! Scegli tra 8 e 15.");
            else if (pg.forza - 8 > PuntiTotali) System.out.println("Punti insufficienti!");
        } while (pg.forza < 8 || pg.forza > 15 || pg.forza - 8 > PuntiTotali);
        PuntiTotali -= (pg.forza - 8);

        // DESTREZZA
        do {
            System.out.print("Destrezza (8-15, punti rimasti: " + PuntiTotali + "): ");
            pg.destrezza = Console.readInt();
            if (pg.destrezza < 8 || pg.destrezza > 15) System.out.println("Valore non valido! Scegli tra 8 e 15.");
            else if (pg.destrezza - 8 > PuntiTotali) System.out.println("Punti insufficienti!");
        } while (pg.destrezza < 8 || pg.destrezza > 15 || pg.destrezza - 8 > PuntiTotali);
        PuntiTotali -= (pg.destrezza - 8);

        // COSTITUZIONE
        do {
            System.out.print("Costituzione (8-15, punti rimasti: " + PuntiTotali + "): ");
            pg.costituzione = Console.readInt();
            if (pg.costituzione < 8 || pg.costituzione > 15) System.out.println("Valore non valido! Scegli tra 8 e 15.");
            else if (pg.costituzione - 8 > PuntiTotali) System.out.println("Punti insufficienti!");
        } while (pg.costituzione < 8 || pg.costituzione > 15 || pg.costituzione - 8 > PuntiTotali);
        PuntiTotali -= (pg.costituzione - 8);

        // INTELLIGENZA
        do {
            System.out.print("Intelligenza (8-15, punti rimasti: " + PuntiTotali + "): ");
            pg.intelligenza = Console.readInt();
            if (pg.intelligenza < 8 || pg.intelligenza > 15) System.out.println("Valore non valido! Scegli tra 8 e 15.");
            else if (pg.intelligenza - 8 > PuntiTotali) System.out.println("Punti insufficienti!");
        } while (pg.intelligenza < 8 || pg.intelligenza > 15 || pg.intelligenza - 8 > PuntiTotali);
        PuntiTotali -= (pg.intelligenza - 8);

        // SAGGEZZA
        do {
            System.out.print("Saggezza (8-15, punti rimasti: " + PuntiTotali + "): ");
            pg.saggezza = Console.readInt();
            if (pg.saggezza < 8 || pg.saggezza > 15) System.out.println("Valore non valido! Scegli tra 8 e 15.");
            else if (pg.saggezza - 8 > PuntiTotali) System.out.println("Punti insufficienti!");
        } while (pg.saggezza < 8 || pg.saggezza > 15 || pg.saggezza - 8 > PuntiTotali);
        PuntiTotali -= (pg.saggezza - 8);

        // CARISMA
        do {
            System.out.print("Carisma (8-15, punti rimasti: " + PuntiTotali + "): ");
            pg.carisma = Console.readInt();
            if (pg.carisma < 8 || pg.carisma > 15) System.out.println("Valore non valido! Scegli tra 8 e 15.");
            else if (pg.carisma - 8 > PuntiTotali) System.out.println("Punti insufficienti!");
        } while (pg.carisma < 8 || pg.carisma > 15 || pg.carisma - 8 > PuntiTotali);
        PuntiTotali -= (pg.carisma - 8);

        // RIASSEGNAZIONE PUNTI RIMASTI - switch al posto di if/else if
        while (PuntiTotali > 0) {
            System.out.println("Ti sono rimasti " + PuntiTotali + " punti! A quale caratteristica vuoi aggiungerli?");
            System.out.println("1. Forza        (attuale: " + pg.forza + ")");
            System.out.println("2. Destrezza    (attuale: " + pg.destrezza + ")");
            System.out.println("3. Costituzione (attuale: " + pg.costituzione + ")");
            System.out.println("4. Intelligenza (attuale: " + pg.intelligenza + ")");
            System.out.println("5. Saggezza     (attuale: " + pg.saggezza + ")");
            System.out.println("6. Carisma      (attuale: " + pg.carisma + ")");
            int scelta = Console.readInt();

            // SWITCH - sostituisce la catena di if/else if
            switch (scelta) {
                case 1:
                    if (pg.forza < 15) { pg.forza++; PuntiTotali--; }
                    else System.out.println("Caratteristica gia' al massimo!");
                    break;
                case 2:
                    if (pg.destrezza < 15) { pg.destrezza++; PuntiTotali--; }
                    else System.out.println("Caratteristica gia' al massimo!");
                    break;
                case 3:
                    if (pg.costituzione < 15) { pg.costituzione++; PuntiTotali--; }
                    else System.out.println("Caratteristica gia' al massimo!");
                    break;
                case 4:
                    if (pg.intelligenza < 15) { pg.intelligenza++; PuntiTotali--; }
                    else System.out.println("Caratteristica gia' al massimo!");
                    break;
                case 5:
                    if (pg.saggezza < 15) { pg.saggezza++; PuntiTotali--; }
                    else System.out.println("Caratteristica gia' al massimo!");
                    break;
                case 6:
                    if (pg.carisma < 15) { pg.carisma++; PuntiTotali--; }
                    else System.out.println("Caratteristica gia' al massimo!");
                    break;
                default:
                    System.out.println("Scelta non valida!");
            }
        }

        // RIEPILOGO PERSONAGGIO CON MODIFICATORI
        System.out.println();
        System.out.println("=== Scheda Personaggio ===");
        System.out.println("Nome:   " + pg.nome);
        System.out.println("Specie: " + pg.specie);
        System.out.println("Classe: " + pg.classe);
        System.out.println("PF:     " + pg.puntiFerita);
        System.out.println("CA:     " + pg.classeArmatura);
        System.out.println("FOR: " + pg.forza + " (mod: " + Personaggio.calcolaModificatore(pg.forza) + ")");
        System.out.println("DES: " + pg.destrezza + " (mod: " + Personaggio.calcolaModificatore(pg.destrezza) + ")");
        System.out.println("COS: " + pg.costituzione + " (mod: " + Personaggio.calcolaModificatore(pg.costituzione) + ")");
        System.out.println("INT: " + pg.intelligenza + " (mod: " + Personaggio.calcolaModificatore(pg.intelligenza) + ")");
        System.out.println("SAG: " + pg.saggezza + " (mod: " + Personaggio.calcolaModificatore(pg.saggezza) + ")");
        System.out.println("CAR: " + pg.carisma + " (mod: " + Personaggio.calcolaModificatore(pg.carisma) + ")");
        System.out.println();
    }

    // SCELTA MODIFICATORE - chiamata dal SimulatoreDadi durante il ciclo dei tiri
    // SWITCH al posto di if/else if
    public static int scegliModificatore(Personaggio pg) {
        System.out.println("Quale caratteristica usi?");
        System.out.println("1. Forza        (mod: " + Personaggio.calcolaModificatore(pg.forza) + ")");
        System.out.println("2. Destrezza    (mod: " + Personaggio.calcolaModificatore(pg.destrezza) + ")");
        System.out.println("3. Costituzione (mod: " + Personaggio.calcolaModificatore(pg.costituzione) + ")");
        System.out.println("4. Intelligenza (mod: " + Personaggio.calcolaModificatore(pg.intelligenza) + ")");
        System.out.println("5. Saggezza     (mod: " + Personaggio.calcolaModificatore(pg.saggezza) + ")");
        System.out.println("6. Carisma      (mod: " + Personaggio.calcolaModificatore(pg.carisma) + ")");
        int sceltaStat = Console.readInt();

        switch (sceltaStat) {
            case 1: return Personaggio.calcolaModificatore(pg.forza);
            case 2: return Personaggio.calcolaModificatore(pg.destrezza);
            case 3: return Personaggio.calcolaModificatore(pg.costituzione);
            case 4: return Personaggio.calcolaModificatore(pg.intelligenza);
            case 5: return Personaggio.calcolaModificatore(pg.saggezza);
            default: return Personaggio.calcolaModificatore(pg.carisma);
        }
    }
}
 
