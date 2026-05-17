import com.generation.library.*;
 
// SIMULATORE DADI - gestisce il ciclo completo dei tiri D&D
public class SimulatoreDadi {
 
    static void avvia(Personaggio pg) {
 
        // INFORMAZIONI SUI DADI
        System.out.println("=== Simulatore dadi D&D ===");
        System.out.println("Servono informazioni sui dadi?");
        String ris = Console.readString();
        if (ris.equalsIgnoreCase("si")) {
            System.out.println("d4: danni piccoli, magie deboli, armi leggere come il pugnale");
            System.out.println("d6: armi comuni, incantesimi, danni medi");
            System.out.println("d8: armi piu' forti, cure, capacita' intermedie");
            System.out.println("d10: armi pesanti, alcune magie");
            System.out.println("d12: armi enormi, danni molto alti");
            System.out.println("d20: attaccare, prove abilita', salvezza, controlli generali");
            System.out.println("d100: probabilita', eventi casuali, effetti speciali");
        } else {
            System.out.println("Va bene, continuiamo.");
        }
 
        // CICLO PRINCIPALE - continua finche' l'utente non vuole smettere
        boolean rilancia = true;
        while (rilancia == true) {
 
            // SCELTA TIPO DI TIRO
            System.out.println("Che tipo di tiro vuoi fare?");
            System.out.println("1. Tiro per colpire");
            System.out.println("2. Tiro di abilita'");
            int tipoTiro = Console.readInt();
 
            // SCELTA CARATTERISTICA - il modificatore dipende dalla caratteristica usata
            System.out.println("Quale caratteristica usi?");
            System.out.println("1. Forza        (mod: " + calcolaModificatore(pg.forza)        + ")");
            System.out.println("2. Destrezza    (mod: " + calcolaModificatore(pg.destrezza)     + ")");
            System.out.println("3. Costituzione (mod: " + calcolaModificatore(pg.costituzione)  + ")");
            System.out.println("4. Intelligenza (mod: " + calcolaModificatore(pg.intelligenza)  + ")");
            System.out.println("5. Saggezza     (mod: " + calcolaModificatore(pg.saggezza)      + ")");
            System.out.println("6. Carisma      (mod: " + calcolaModificatore(pg.carisma)       + ")");
            int sceltaStat = Console.readInt();
 
            // ASSEGNO IL MODIFICATORE IN BASE ALLA CARATTERISTICA SCELTA
            int modificatore;
            if (sceltaStat == 1) {
                modificatore = calcolaModificatore(pg.forza);
            } else if (sceltaStat == 2) {
                modificatore = calcolaModificatore(pg.destrezza);
            } else if (sceltaStat == 3) {
                modificatore = calcolaModificatore(pg.costituzione);
            } else if (sceltaStat == 4) {
                modificatore = calcolaModificatore(pg.intelligenza);
            } else if (sceltaStat == 5) {
                modificatore = calcolaModificatore(pg.saggezza);
            } else {
                modificatore = calcolaModificatore(pg.carisma);
            }
 
            // VANTAGGIO/SVANTAGGIO
            System.out.print("Hai vantaggio, svantaggio, o nessuno dei due? (v/s/no): ");
            String vs = Console.readString();
 
            // LANCIO DEL D20
            int tiroBase;
            if (vs.equals("v")) {
                // VANTAGGIO - lancia due D20 e tiene il piu' alto
                int dado1 = (int)(Math.random() * 20) + 1;
                int dado2 = (int)(Math.random() * 20) + 1;
                System.out.println("Dadi: " + dado1 + " e " + dado2);
                tiroBase = dado1 > dado2 ? dado1 : dado2;
                System.out.println("Tieni il piu' alto: " + tiroBase);
            } else if (vs.equals("s")) {
                // SVANTAGGIO - lancia due D20 e tiene il piu' basso
                int dado1 = (int)(Math.random() * 20) + 1;
                int dado2 = (int)(Math.random() * 20) + 1;
                System.out.println("Dadi: " + dado1 + " e " + dado2);
                tiroBase = dado1 < dado2 ? dado1 : dado2;
                System.out.println("Tieni il piu' basso: " + tiroBase);
            } else {
                // NESSUNO - lancio normale
                tiroBase = (int)(Math.random() * 20) + 1;
                System.out.println("D20: " + tiroBase);
            }
 
            if (tipoTiro == 2) {
 
                // TIRO DI ABILITA'
                System.out.println("--- Tiro di abilita' ---");
 
                if (tiroBase == 1) {
                    // FUMBLE - fallimento automatico, modificatore non applicato
                    System.out.println("*** FUMBLE! ***");
                    int effetto = (int)(Math.random() * 3) + 1;
                    if (effetto == 1) System.out.println("Hai colpito te stesso!");
                    if (effetto == 2) System.out.println("Hai perso l'arma!");
                    if (effetto == 3) System.out.println("Sei caduto a terra!");
                } else if (tiroBase == 20) {
                    // CRITICO - successo automatico, mostro comunque il totale
                    System.out.println("*** CRITICO! ***");
                    int tiroFinale = tiroBase + modificatore;
                    System.out.println("Tiro finale: " + tiroBase + " + mod(" + modificatore + ") = " + tiroFinale);
                } else {
                    // TIRO NORMALE - applico il modificatore
                    int tiroFinale = tiroBase + modificatore;
                    System.out.println("Tiro finale: " + tiroBase + " + mod(" + modificatore + ") = " + tiroFinale);
                }
 
            } else {
 
                // TIRO PER COLPIRE
                System.out.println("--- Tiro per colpire ---");
 
                if (tiroBase == 1) {
                    // FUMBLE - mancato automatico, modificatore non applicato
                    System.out.println("*** FUMBLE! Hai mancato! ***");
                    int effetto = (int)(Math.random() * 3) + 1;
                    if (effetto == 1) System.out.println("Hai colpito te stesso!");
                    if (effetto == 2) System.out.println("Hai perso l'arma!");
                    if (effetto == 3) System.out.println("Sei caduto a terra!");
                } else {
                    if (tiroBase == 20) {
                        // CRITICO - colpisce sempre indipendentemente dalla CA
                        System.out.println("*** CRITICO! ***");
                    }
 
                    // SOLO QUI APPLICO IL MODIFICATORE - il fumble non arriva mai qui
                    int tiroFinale = tiroBase + modificatore;
                    System.out.println("Tiro finale: " + tiroBase + " + mod(" + modificatore + ") = " + tiroFinale);
 
                    // CONFRONTO CON LA CLASSE ARMATURA
                    System.out.print("Classe Armatura del nemico? ");
                    int ca = Console.readInt();
 
                    if (tiroFinale < ca && tiroBase != 20) {
                        // tiroBase != 20 perche' il critico colpisce sempre
                        System.out.println("Hai mancato! CA nemica: " + ca);
                    } else {
 
                        // COLPO ANDATO A SEGNO
                        System.out.println("Hai colpito! Tiro il danno...");
                        int totale = 0;
                        String riepilogo = "";
 
                        // CICLO DADI DANNO
                        boolean AltroDado = true;
                        while (AltroDado == true) {
 
                            System.out.print("Quante facce ha il dado danno? ");
                            int facce = Console.readInt();
 
                            // VALIDAZIONE DADO
                            while (dadoValido(facce) == false) {
                                System.out.println("Dado non valido! Scegli tra: 4, 6, 8, 10, 12, 20, 100");
                                System.out.print("Quante facce ha il dado? ");
                                facce = Console.readInt();
                            }
 
                            System.out.print("Quanti dadi lanci? ");
                            int q = Console.readInt();
 
                            // FOR - lancia q dadi e accumula risultati
                            for (int i = 0; i < q; i++) {
                                int risultato = (int)(Math.random() * facce) + 1;
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
 
            // CHIEDO SE VUOLE RILANCIARE
            System.out.print("Vuoi lanciare ancora? (s/n): ");
            String risposta = Console.readString();
            rilancia = risposta.equals("s");
         
        }
    }

    // DADO - controlla che il dado esista in D&D
    static boolean dadoValido(int facce) {
        return facce == 4  || facce == 6  || facce == 8 ||
               facce == 10 || facce == 12 || facce == 20 || facce == 100;
    }
}