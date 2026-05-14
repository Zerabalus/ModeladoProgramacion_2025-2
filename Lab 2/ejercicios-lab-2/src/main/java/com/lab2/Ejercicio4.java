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

        // Si la subcadena es más larga que la cadena, no puede estar contenida
        if (longitudS > longitudT) {
            return -1;
        }

        for (int i = 0; i <= longitudT - longitudS; i++) {
            int j;
            for (j = 0; j < longitudS; j++) {
                if (t.charAt(i + j) != s.charAt(j)) {
                    break; // Si no coincide, salimos del bucle interno
                }
            }
            // Si j alcanza la longitud de s, significa que encontramos la subcadena
            if (j == longitudS) {
                return i; // Devolvemos el índice donde comienza la subcadena
            }
        }
        return -1; // Si no se encuentra, devolvemos -1
    }
}