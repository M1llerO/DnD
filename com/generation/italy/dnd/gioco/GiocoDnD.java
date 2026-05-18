package com.generation.italy.dnd.gioco;

import com.generation.italy.dnd.personaggio.Personaggio;
import com.generation.italy.dnd.creazione.CreazionePersonaggio;
import com.generation.italy.dnd.caratteristiche.CaratteristichePersonaggio;
import com.generation.italy.dnd.simulatore.SimulatoreDadi;

// GIOCO DND - classe principale, contiene il main
public class GiocoDnD {

    public static void main(String[] args) {

        // 1. Crea il personaggio (nome, specie, classe, PF, CA)
        Personaggio pg = CreazionePersonaggio.crea();

        // 2. Assegna le caratteristiche
        CaratteristichePersonaggio.assegna(pg);

        // 3. Avvia il simulatore di dadi
        SimulatoreDadi.avvia(pg);
    }
}
