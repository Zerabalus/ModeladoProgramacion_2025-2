package com.lab2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class Ejercicio4Test {

    /**
     * Prueba que el método indiceOcurrencia encuentra correctamente el índice
     * de la primera ocurrencia de la subcadena "tristes" en la cadena
     * "trestristestigrestragabantrigoenuntrigal", que debería ser 4.
     */

    @Test
    public void testIndiceOcurrencia_Ejemplo1() {
        Ejercicio4 ejercicio4 = new Ejercicio4();
        String t = "trestristestigrestragabantrigoenuntrigal";
        String s = "tristes";
        int resultado = ejercicio4.indiceOcurrencia(t, s);
        assertEquals(4, resultado);
    }

    /**
     * Comprueba que el índice de la subcadena "tigresa" en la cadena
     * "trestristestigrestragabantrigoenuntrigal"
     * es -1, ya que no se encuentra en la cadena.
     */
    @Test
    public void testIndiceOcurrencia_Ejemplo2() {
        Ejercicio4 ejercicio4 = new Ejercicio4();
        String t = "trestristestigrestragabantrigoenuntrigal";
        String s = "tigresa";
        int resultado = ejercicio4.indiceOcurrencia(t, s);
        assertEquals(-1, resultado);
    }
}
