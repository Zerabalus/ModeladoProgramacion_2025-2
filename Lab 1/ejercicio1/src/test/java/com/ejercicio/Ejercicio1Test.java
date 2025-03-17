package com.ejercicio;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.junit.jupiter.api.Test;

public class Ejercicio1Test {

    /**
     * Prueba unitaria.
     * 
     * La matriz de entrada es:
     * 
     * 1 2 3
     * 4 5 6
     * 7 8 8
     * 
     * El valor repetido esperado es 8 y el valor faltante es 9.
     */

    @Test
    void testEncontrarValores() {
        Ejercicio1 ejercicio = new Ejercicio1();
        int[][] matriz = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 8 }
        };
        int[] salidaEsperada = ejercicio.encontrarValores(matriz);
        assertArrayEquals(new int[] { 8, 9 }, salidaEsperada);
    }

    /**
     * Prueba Unitaria 2.
     * 
     * La matriz es:
     * 
     * 9 1 7
     * 8 9 2
     * 3 4 6
     * 
     * El valor repetido es el 9 y el valor faltante es el 5.
     */

    @Test
    void testEncontrarValores2() {
        Ejercicio1 ejercicio = new Ejercicio1();
        int[][] matriz = {
                { 9, 1, 7 },
                { 8, 9, 2 },
                { 3, 4, 6 }
        };
        int[] salidaEsperada = ejercicio.encontrarValores(matriz);
        assertArrayEquals(new int[] { 9, 5 }, salidaEsperada);
    }
}
