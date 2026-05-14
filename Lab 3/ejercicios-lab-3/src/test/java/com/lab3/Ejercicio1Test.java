package com.lab3;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.junit.jupiter.api.Test;

public class Ejercicio1Test {

    @Test
    public void testConvertirCeros_CasoCeroCentral() {
        // Arrange
        Ejercicio1 ejercicio = new Ejercicio1();
        int[][] entrada = {
                { 1, 1, 1 },
                { 1, 0, 1 },
                { 1, 1, 1 }
        };
        int[][] esperado = {
                { 1, 0, 1 },
                { 0, 0, 0 },
                { 1, 0, 1 }
        };

        ejercicio.convertirCeros(entrada);

        assertArrayEquals(esperado, entrada, "La fila y columna del cero deben ser ceros");
    }

    @Test
    public void testConvertirCeros_CasoMultiplesCerosEnFila() {
        // Arrange
        Ejercicio1 ejercicio = new Ejercicio1();
        int[][] entrada = {
                { 0, 1, 2, 0 },
                { 3, 4, 5, 2 },
                { 1, 3, 1, 5 }
        };
        int[][] esperado = {
                { 0, 0, 0, 0 },
                { 0, 4, 5, 0 },
                { 0, 3, 1, 0 }
        };

        ejercicio.convertirCeros(entrada);

        assertArrayEquals(esperado, entrada, "La fila y columna de los ceros deben ser ceros");
    }

    @Test
    public void testConvertirCeros_MatrizSinCeros() {
        // Arrange
        Ejercicio1 ejercicio = new Ejercicio1();
        int[][] entrada = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };
        int[][] esperado = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };

        ejercicio.convertirCeros(entrada);

        assertArrayEquals(esperado, entrada, "La matriz sin ceros debe quedar igual");
    }

}
