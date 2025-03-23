package com.lab2;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class Ejercicio2Test {

    /**
     * Comprueba que el método indicesDistintos regrese true cuando existen dos
     * índices i y j en el array A, tales que A[i] == A[j] y la diferencia entre
     * i y j es menor o igual a k.
     * 
     * En este caso, A = [1, 2, 3, 1] y k = 3, por lo que el resultado debe
     * ser true, ya que existen los índices 0 y 3 que cumplen la condición.
     */

    @Test
    public void testIndicesDistintos_Ejemplo1() {
        Ejercicio2 ejercicio2 = new Ejercicio2();
        int[] A = { 1, 2, 3, 1 };
        int k = 3;
        boolean resultado = ejercicio2.indicesDistintos(A, k);
        assertTrue(resultado);
    }

    /**
     * Verifica que el método indicesDistintos regrese false cuando no existen dos
     * índices i y j en el array A, tales que A[i] == A[j] y la diferencia entre
     * i y j es menor o igual a k.
     * 
     * En este caso, A = [1, 2, 3, 1, 2, 3] y k = 2, por lo que el resultado debe
     * ser false, ya que no hay dos índices que cumplan la condición.
     */

    @Test
    public void testIndicesDistintos_Ejemplo2() {
        Ejercicio2 ejercicio2 = new Ejercicio2();
        int[] A = { 1, 2, 3, 1, 2, 3 };
        int k = 2;
        boolean resultado = ejercicio2.indicesDistintos(A, k);
        assertFalse(resultado);
    }
}