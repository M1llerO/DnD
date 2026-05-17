import com.generation.library.*;

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
