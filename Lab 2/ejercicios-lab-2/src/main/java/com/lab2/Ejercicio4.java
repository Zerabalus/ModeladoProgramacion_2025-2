package com.lab2;

/**
 * Clase del método que dadas dos cadenas regrresa el índice de la primera
 * ocurrencia de una subcadena dentro de otra cadena.
 */

public class Ejercicio4 {

    /**
     * Encuentra el índice de la primera ocurrencia de la cadena s
     * dentro de la cadena t.
     * 
     * @param t la cadena a buscar.
     * @param s la subcadena a buscar.
     * @return el índice del primer caracter de la subcadena en la cadena, o -1
     *         si no se encontró (no es parte de t).
     */
    public int indiceOcurrencia(String t, String s) {
        int longitudT = t.length();
        int longitudS = s.length();
        int indiceN = 0;
        for (int i = 0; i < longitudT; i++) {
            // mientras los caracteres sean iguales, incrementa el indice de s
            if (t.charAt(i) == s.charAt(indiceN)) {
                indiceN++;
            } else {
                // comienza desde el siguiente índice del índice de inicio anterior
                i = i - indiceN;
                // s debe comenzar desde el índice 0
                indiceN = 0;
            }
            // comprobar si el indice de s alcanzó la longitud s
            if (indiceN == longitudS) {
                // devolver el primer índice
                return i - longitudS + 1;
            }
        }
        return -1;
    }
}
