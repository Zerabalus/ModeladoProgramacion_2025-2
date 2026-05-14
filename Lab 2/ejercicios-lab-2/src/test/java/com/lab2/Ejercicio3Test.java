package com.lab2;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class Ejercicio3Test {

    /**
     * Verifica que el método esFeliz regrese true para el número 19, ya que
     * eventualmente termina en 1 al reemplazarlo por la suma de los cuadrados de
     * sus dígitos.
     */
    @Test
    public void testEsFeliz_Ejemplo1() {
        Ejercicio3 ejercicio3 = new Ejercicio3();
        int entrada = 19;
        boolean resultado = ejercicio3.esFeliz(entrada);
        assertTrue(resultado);
    }

    /**
     * Verifica que el método esFeliz regrese false para el número 2, ya que no
     * es un número feliz y no llega a 1 al reemplazarlo por la suma de los
     * cuadrados de sus dígitos.
     */

    @Test
    public void testEsFeliz_Ejemplo2() {
        Ejercicio3 ejercicio3 = new Ejercicio3();
        int entrada = 2;
        boolean resultado = ejercicio3.esFeliz(entrada);
        assertFalse(resultado);
    }
}
