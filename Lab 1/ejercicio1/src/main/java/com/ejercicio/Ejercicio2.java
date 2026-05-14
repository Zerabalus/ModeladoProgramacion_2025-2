package com.ejercicio;

/**
 * Devuelve el prefijo mas grande que tienen en común las cadenas dadas.
 * 
 * @param listaDeCadenas   El arreglo de cadenas.
 * @param prefijoMasGrande El prefijo mas grande de las cadenas.
 * @param indice           El indice del prefijo mas grande.
 * @param charAt           El caracter en el indice.
 * @return El prefijo mas grande.
 */

public class Ejercicio2 {

    public String prefijoMasGrande(String[] listaDeCadenas) {
        if (listaDeCadenas == null || listaDeCadenas.length == 0) {
            return "";
        }

        for (int indice = 0; indice < listaDeCadenas[0].length(); indice++) {
            for (int indiceCadena = 1; indiceCadena < listaDeCadenas.length; indiceCadena++) {
                if (indice >= listaDeCadenas[indiceCadena].length()
                        || listaDeCadenas[indiceCadena].charAt(indice) != listaDeCadenas[0].charAt(indice)) {
                    return listaDeCadenas[0].substring(0, indice);
                }
            }
        }

        return listaDeCadenas[0];
    }
}