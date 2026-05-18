package com.generation.italy.dnd.simdado;

// DADO - contiene solo la meccanica del dado, niente input utente
public class Dado {

    // TIRA - restituisce un numero casuale da 1 a facce
    public static int tira(int facce) {
        return (int)(Math.random() * facce) + 1;
    }

    // DADO VALIDO - controlla che il dado esista in D&D
    public static boolean dadoValido(int facce) {
        return facce == 4  || facce == 6  || facce == 8 ||
                facce == 10 || facce == 12 || facce == 20 || facce == 100;
    }
}
