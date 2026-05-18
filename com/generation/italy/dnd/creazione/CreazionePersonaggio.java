package com.generation.italy.dnd.creazione;

import com.generation.italy.dnd.personaggio.Personaggio;
import com.generation.library.*;

// CREAZIONE PERSONAGGIO - gestisce nome, specie, classe, PF e CA
public class CreazionePersonaggio {

    public static Personaggio crea() {

        Personaggio pg = new Personaggio();

        System.out.println("=== Creazione Personaggio ===");

        // NOME
        System.out.print("Nome del personaggio: ");
        pg.nome = Console.readString();

        // SPECIE CON VALIDAZIONE
        System.out.print("Specie (Umano, Elfo, Nano, Halfling, Dragonborn, Gnomo, Tiefling, Orco, Goliath, Aasimar): ");
        pg.specie = Console.readString();
        while (specieValida(pg.specie) == false) {
            System.out.println("Specie non valida! Riprova.");
            System.out.print("Specie: ");
            pg.specie = Console.readString();
        }

        // CLASSE CON VALIDAZIONE
        System.out.print("Classe (Barbaro, Bardo, Chierico, Druido, Guerriero, Monaco, Paladino, Ranger, Ladro, Stregone, Warlock, Mago): ");
        pg.classe = Console.readString();
        while (classeValida(pg.classe) == false) {
            System.out.println("Classe non valida! Riprova.");
            System.out.print("Classe: ");
            pg.classe = Console.readString();
        }

        pg.livello = 1;

        // PUNTI FERITA E CLASSE ARMATURA
        System.out.print("Punti Ferita: ");
        pg.puntiFerita = Console.readInt();
        System.out.print("Classe Armatura: ");
        pg.classeArmatura = Console.readInt();

        return pg;
    }

    // VALIDAZIONE SPECIE - restituisce true se la specie esiste in D&D 2024
    public static boolean specieValida(String specie) {
        return specie.equalsIgnoreCase("Umano")      ||
                specie.equalsIgnoreCase("Elfo")       ||
                specie.equalsIgnoreCase("Nano")       ||
                specie.equalsIgnoreCase("Halfling")   ||
                specie.equalsIgnoreCase("Dragonborn") ||
                specie.equalsIgnoreCase("Gnomo")      ||
                specie.equalsIgnoreCase("Tiefling")   ||
                specie.equalsIgnoreCase("Orco")       ||
                specie.equalsIgnoreCase("Goliath")    ||
                specie.equalsIgnoreCase("Aasimar");
    }

    // VALIDAZIONE CLASSE - restituisce true se la classe esiste in D&D 2024
    public static boolean classeValida(String classe) {
        return classe.equalsIgnoreCase("Barbaro")   ||
                classe.equalsIgnoreCase("Bardo")     ||
                classe.equalsIgnoreCase("Chierico")  ||
                classe.equalsIgnoreCase("Druido")    ||
                classe.equalsIgnoreCase("Guerriero") ||
                classe.equalsIgnoreCase("Monaco")    ||
                classe.equalsIgnoreCase("Paladino")  ||
                classe.equalsIgnoreCase("Ranger")    ||
                classe.equalsIgnoreCase("Ladro")     ||
                classe.equalsIgnoreCase("Stregone")  ||
                classe.equalsIgnoreCase("Warlock")   ||
                classe.equalsIgnoreCase("Mago");
    }
}
