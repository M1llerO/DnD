import com.generation.library.*;
 
// CARATTERISTICHE PERSONAGGIO - inserimento FOR, DES, COS, INT, SAG, CAR
// + riepilogo scheda + scelta modificatore durante il gioco
 
public class CaratteristichePersonaggio {

 
    // INSERIMENTO STATISTICHE E RIEPILOGO SCHEDA
    static void assegna(Personaggio pg) {
 
        int PuntiTotali = 27;
        while ( PuntiTotali > 0) {
        System.out.println("Hai tutte le caratteristiche ad 8, e 27 punti disponibili.");
        System.out.println("Incrementa le tue caratteristiche fino ad un massimo di 15.");
        System.out.println();
 
        // FORZA - do/while controlla che il valore sia tra 8 e 15 e che i punti bastino
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
        System.out.println("Punti rimasti: " + PuntiTotali);
        System.out.println();
    }
 
    // SCELTA MODIFICATORE - chiamata dal SimulatoreDadi durante il ciclo dei tiri
    static int scegliModificatore(Personaggio pg) {
        System.out.println("Quale caratteristica usi?");
        System.out.println("1. Forza        (mod: " + Personaggio.calcolaModificatore(pg.forza) + ")");
        System.out.println("2. Destrezza    (mod: " + Personaggio.calcolaModificatore(pg.destrezza) + ")");
        System.out.println("3. Costituzione (mod: " + Personaggio.calcolaModificatore(pg.costituzione) + ")");
        System.out.println("4. Intelligenza (mod: " + Personaggio.calcolaModificatore(pg.intelligenza) + ")");
        System.out.println("5. Saggezza     (mod: " + Personaggio.calcolaModificatore(pg.saggezza) + ")");
        System.out.println("6. Carisma      (mod: " + Personaggio.calcolaModificatore(pg.carisma) + ")");
        int sceltaStat = Console.readInt();
 
        if (sceltaStat == 1) return Personaggio.calcolaModificatore(pg.forza);
        if (sceltaStat == 2) return Personaggio.calcolaModificatore(pg.destrezza);
        if (sceltaStat == 3) return Personaggio.calcolaModificatore(pg.costituzione);
        if (sceltaStat == 4) return Personaggio.calcolaModificatore(pg.intelligenza);
        if (sceltaStat == 5) return Personaggio.calcolaModificatore(pg.saggezza);
        return Personaggio.calcolaModificatore(pg.carisma);
    }
}
