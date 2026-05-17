import com.generation.library.*;
 
// CARATTERISTICHE PERSONAGGIO - inserimento FOR, DES, COS, INT, SAG, CAR
// + riepilogo scheda + scelta modificatore durante il gioco
public class CaratteristichePersonaggio {
 
    // INSERIMENTO STATISTICHE E RIEPILOGO SCHEDA
    static void assegna(Personaggio pg) {
 
        System.out.println("Inserisci le statistiche (valore da 1 a 20):");
        System.out.print("Forza: ");
        pg.forza = Console.readInt();
        System.out.print("Destrezza: ");
        pg.destrezza = Console.readInt();
        System.out.print("Costituzione: ");
        pg.costituzione = Console.readInt();
        System.out.print("Intelligenza: ");
        pg.intelligenza = Console.readInt();
        System.out.print("Saggezza: ");
        pg.saggezza = Console.readInt();
        System.out.print("Carisma: ");
        pg.carisma = Console.readInt();
 
        // RIEPILOGO PERSONAGGIO CON MODIFICATORI
        System.out.println();
        System.out.println("=== Scheda Personaggio ===");
        System.out.println("Nome:    " + pg.nome);
        System.out.println("Specie:  " + pg.specie);
        System.out.println("Classe:  " + pg.classe);
        System.out.println("PF:      " + pg.puntiFerita);
        System.out.println("CA:      " + pg.classeArmatura);
        System.out.println("FOR: " + pg.forza        + " (mod: " + Personaggio.calcolaModificatore(pg.forza)        + ")");
        System.out.println("DES: " + pg.destrezza    + " (mod: " + Personaggio.calcolaModificatore(pg.destrezza)    + ")");
        System.out.println("COS: " + pg.costituzione + " (mod: " + Personaggio.calcolaModificatore(pg.costituzione) + ")");
        System.out.println("INT: " + pg.intelligenza + " (mod: " + Personaggio.calcolaModificatore(pg.intelligenza) + ")");
        System.out.println("SAG: " + pg.saggezza     + " (mod: " + Personaggio.calcolaModificatore(pg.saggezza)     + ")");
        System.out.println("CAR: " + pg.carisma      + " (mod: " + Personaggio.calcolaModificatore(pg.carisma)      + ")");
        System.out.println();
    }
 
    // SCELTA MODIFICATORE - chiamata dal SimulatoreDadi durante il ciclo dei tiri
    static int scegliModificatore(Personaggio pg) {
        System.out.println("Quale caratteristica usi?");
        System.out.println("1. Forza        (mod: " + Personaggio.calcolaModificatore(pg.forza)        + ")");
        System.out.println("2. Destrezza    (mod: " + Personaggio.calcolaModificatore(pg.destrezza)     + ")");
        System.out.println("3. Costituzione (mod: " + Personaggio.calcolaModificatore(pg.costituzione)  + ")");
        System.out.println("4. Intelligenza (mod: " + Personaggio.calcolaModificatore(pg.intelligenza)  + ")");
        System.out.println("5. Saggezza     (mod: " + Personaggio.calcolaModificatore(pg.saggezza)      + ")");
        System.out.println("6. Carisma      (mod: " + Personaggio.calcolaModificatore(pg.carisma)       + ")");
        int sceltaStat = Console.readInt();
 
        if (sceltaStat == 1) return Personaggio.calcolaModificatore(pg.forza);
        if (sceltaStat == 2) return Personaggio.calcolaModificatore(pg.destrezza);
        if (sceltaStat == 3) return Personaggio.calcolaModificatore(pg.costituzione);
        if (sceltaStat == 4) return Personaggio.calcolaModificatore(pg.intelligenza);
        if (sceltaStat == 5) return Personaggio.calcolaModificatore(pg.saggezza);
        return Personaggio.calcolaModificatore(pg.carisma);
    }
}