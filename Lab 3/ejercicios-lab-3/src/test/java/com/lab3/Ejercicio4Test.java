package com.lab3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class Ejercicio4Test {

    @Test
    void testEjemplo1() {
        Ejercicio4 ejercicio = new Ejercicio4();
        int[] entrada = { 2, 2, 1 };
        int esperado = 1;
        assertEquals(esperado, ejercicio.encontrarNumeroUnico(entrada),
                "Debería retornar 1 para la entrada [2, 2, 1]");
    }

    @Test
    void testEjemplo2() {
        Ejercicio4 ejercicio = new Ejercicio4();
        int[] entrada = { 4, 1, 2, 1, 2 };
        int esperado = 4;
        assertEquals(esperado, ejercicio.encontrarNumeroUnico(entrada),
                "Debería retornar 4 para la entrada [4, 1, 2, 1, 2]");
    }

    @Test
    void testNumerosNegativos() {
        Ejercicio4 ejercicio = new Ejercicio4();
        int[] entrada = { -1, -1, -2, -2, -3 };
        int esperado = -3;
        assertEquals(esperado, ejercicio.encontrarNumeroUnico(entrada),
                "Debería funcionar correctamente con números negativos");
    }

}
