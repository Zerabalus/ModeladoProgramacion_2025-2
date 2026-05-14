package com.lab3;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.junit.jupiter.api.Test;

class Ejercicio2Test {

    @Test
    void testCombinar_IntervalosSuperpuestos() {

        Ejercicio2 ejercicio = new Ejercicio2();
        int[][] entrada = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
        int[][] esperado = { { 1, 6 }, { 8, 10 }, { 15, 18 } };

        int[][] resultado = ejercicio.combinar(entrada);

        assertArrayEquals(esperado, resultado, "Debería combinar intervalos superpuestos [1,3] y [2,6] en [1,6]");
    }

    @Test
    void testCombinar_IntervalosSinSuperposicion() {

        Ejercicio2 ejercicio = new Ejercicio2();
        int[][] entrada = { { 1, 2 }, { 3, 4 }, { 5, 6 } };
        int[][] esperado = { { 1, 2 }, { 3, 4 }, { 5, 6 } };

        int[][] resultado = ejercicio.combinar(entrada);

        assertArrayEquals(esperado, resultado, "Debería mantener intervalos sin superposición");
    }

    @Test
    void testCombinar_IntervalosIguales() {

        Ejercicio2 ejercicio = new Ejercicio2();
        int[][] entrada = { { 1, 3 }, { 1, 3 }, { 1, 3 } };
        int[][] esperado = { { 1, 3 } };

        int[][] resultado = ejercicio.combinar(entrada);

        assertArrayEquals(esperado, resultado, "Debería combinar intervalos idénticos en uno solo");
    }

    @Test
    void testCombinar_IntervalosNegativos() {

        Ejercicio2 ejercicio = new Ejercicio2();
        int[][] entrada = { { -5, -2 }, { -3, 0 }, { -1, 4 } };
        int[][] esperado = { { -5, 4 } };

        int[][] resultado = ejercicio.combinar(entrada);

        assertArrayEquals(esperado, resultado, "Debería manejar correctamente intervalos con valores negativos");
    }
}
