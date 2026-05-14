package com.lab2;

/**
 * Dadas dos cadenas nota y texto, comprueba si la nota puede ser
 * generada a partir del contenido del texto.
 * Regresa un booleano que indica si se puede construir o no.
 * 
 * @param nota  La nota a construir.
 * @param texto El texto con el que se va a construir la nota.
 * @param letra Solo puede ser usada una vez en nota
 * @return true si se puede construir, false en caso contrario.
 */

public class Ejercicio1 {

    public boolean puedeGenerarse(String nota, String texto) {
        // convertimos nota en un arreglo para iterar
        char[] letra = nota.toCharArray();
        for (char caracter : letra) {
            int i = texto.indexOf(caracter);
            if (i == -1) {
                return false;
            }
            texto = texto.substring(0, i) + texto.substring(i + 1);
        }
        return true;
    }
}
