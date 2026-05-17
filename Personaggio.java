// CLASSE PERSONAGGIO - contiene tutte le statistiche della scheda
public class Personaggio {
    String nome;
    String specie;
    String classe;
    int livello;
    int forza;
    int destrezza;
    int costituzione;
    int intelligenza;
    int saggezza;
    int carisma;
    int puntiFerita;
    int classeArmatura;

    // CALCOLO MODIFICATORE - formula ufficiale D&D: (punteggio - 10) / 2
    static int calcolaModificatore(int punteggio) {
        return (punteggio - 10) / 2;
    }
}

