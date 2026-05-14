package com.ejercicio;

import java.util.Map;

/**
 * Convierte un número romano a su valor decimal.
 *
 * @param numeroRomano El número romano a convertir.
 * @return El valor decimal convertido de romano.
 */

public class Ejercicio3 {

    public int convertirRomanoADecimal(String numeroRomano) {
        Map<Character, Integer> numerosRomanos = obtenerValoresRomanos();
        int valorDecimal = 0;

        for (int i = 0; i < numeroRomano.length() - 1; i++) {
            int valorActual = numerosRomanos.get(numeroRomano.charAt(i));
            int valorSiguiente = numerosRomanos.get(numeroRomano.charAt(i + 1));

            if (valorActual < valorSiguiente) {
                valorDecimal -= valorActual;
            } else {
                valorDecimal += valorActual;
            }
        }

        valorDecimal += numerosRomanos.get(numeroRomano.charAt(numeroRomano.length() - 1));

        return valorDecimal;
    }

    /**
     * Obtiene un mapeo (hash map) que representa los valores numéricos de los
     * símbolos
     * romanos.
     *
     * @return Un mapeo de caracteres que representan los
     *         símbolos romanos en decimales.
     * 
     */

    private Map<Character, Integer> obtenerValoresRomanos() {
        return Map.of(
                'I', 1,
                'V', 5,
                'X', 10,
                'L', 50,
                'C', 100,
                'D', 500,
                'M', 1000);
    }
}
