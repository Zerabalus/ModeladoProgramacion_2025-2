package com.lab2;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class Ejercicio2Test {

    @Test
    public void testIndicesDistintos_Ejemplo1() {
        Ejercicio2 ejercicio2 = new Ejercicio2();
        int[] A = { 1, 2, 3, 1 };
        int k = 3;
        boolean resultado = ejercicio2.indicesDistintos(A, k);
        assertTrue(resultado); // La salida esperada es true
    }

    @Test
    public void testIndicesDistintos_Ejemplo2() {
        Ejercicio2 ejercicio2 = new Ejercicio2();
        int[] A = { 1, 2, 3, 1, 2, 3 };
        int k = 2;
        boolean resultado = ejercicio2.indicesDistintos(A, k);
        assertFalse(resultado); // La salida esperada es false
    }
}